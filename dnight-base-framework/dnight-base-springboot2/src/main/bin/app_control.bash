#!/bin/bash

set -o pipefail
set -u

EXTERNAL_LOADER_PATH="../conf"
SERVER_PORT=8182
SHUTDOWN_HOST=127.0.0.1
EXEC_STD_OUT=/dev/null

source env.bash

#evironment set
WEB_BIN=`pwd`
CONF_DIR="${WEB_BIN}/../conf"
JAVA_OPTS="${JAVA_OPTS} -Dspring.profiles.active=${PROFILES}"
JAVA_OPTS="${JAVA_OPTS} -Dserver.port=${SERVER_PORT}"
JAVA_OPTS="${JAVA_OPTS} -Dlogging.path=${LOG_ROOT_PATH} -Dendpoints.logfile.external-file=${LOG_ROOT_PATH}/standard-web.log"
JAVA_OPTS="${JAVA_OPTS} -Dloader.path=${WEB_BIN}/../conf,${EXTERNAL_LOADER_PATH}"
SEARCH_API_EXEC="java ${JAVA_OPTS} -jar $WEB_BIN/../standard-web.jar"


#Time Config
START_WAIT=5
SHUT_WAIT=10
KILL_INTERVAL=5
KILL_TIMES=5

#RETURN CODES
RET_SUCCESS=0
RET_INSTANCE_DEAD=1
RET_ERROR_SHUT=2
RET_ERROR_START=3
RET_STATUS_ALIVE=0
RET_STATUS_NOT_ALIVE=1
INSTANCE_PID=base-springframework-web.pid


function get_Pid(){
    if [ ! -z ${INSTANCE_PID} ];then
        if [ -f ${INSTANCE_PID} ];then
            cat "${INSTANCE_PID}"
        fi
    else
        ps -ef | grep -vE "grep $WEB_BIN|$0" | grep ${WEB_BIN} | awk '{print $2}'
    fi
}

#get pid
PID=`get_Pid`

function usage(){
        cat <<EOM
    Purpose  :    This script encapsulates the spring boot jar and just acts like a controller.
    Usage    :    bash ${0} start|shutdown|kill|force|restart|status
    Date     :    2017.03
EOM
}

#test instance alived or not
function is_Instance_Alive(){
    #kill -0 : test process alived or not
    if `kill -0 ${PID} 2>/dev/null` ; then
    #0 stands for success in shell
        return ${RET_SUCCESS}
    else
        return ${RET_INSTANCE_DEAD}
    fi
}

## remove pid file
function remove_Pid(){
   if [ ! -z ${INSTANCE_PID} ];then
       if [ -f ${INSTANCE_PID} ];then
           rm -f ${INSTANCE_PID}
       fi
   fi
}

## shutdown Instance
function shutdown_Instance(){
    if ! is_Instance_Alive ;then
        echo "no need to stop, not found PID"
        return ${RET_SUCCESS}
    else
        echo -n "shutdown instance"
        for((i=0;i<=$KILL_TIMES;i++ ));do   #kill instance for KILL_TIMES, each with KILL_INTERVAL secs
            curl -d "" "http://${SHUTDOWN_HOST}:${SERVER_PORT}/actuator/shutdown"
            sleep_Wait ${KILL_INTERVAL}
            #check if kill of this round success
            if ! is_Instance_Alive ; then
                remove_Pid
                echo shutdown successfully
                return ${RET_SUCCESS}
            fi
        done
        return ${RET_ERROR_SHUT}
    fi
}

#normal kill
function kill_Instance(){
    if ! is_Instance_Alive ;then
        echo "no need to stop, not found PID"
        return ${RET_SUCCESS}
    else
        echo -n "killing $PID "
    for((i=0;i<=$KILL_TIMES;i++ ));do    #kill instance for KILL_TIMES, each with KILL_INTERVAL secs
        kill -15 ${PID}
        sleep_Wait ${KILL_INTERVAL}
        #check if kill of this round success
        if ! is_Instance_Alive ; then
            remove_Pid
            echo kill successfully
            return ${RET_SUCCESS}
        fi
    done
    return ${RET_ERROR_SHUT}
    fi
}
#-9 kill
function force_Instance(){
    if ! is_Instance_Alive ;then
        echo "no need to force kill, not found PID"
        return ${RET_SUCCESS}
    else
    echo -n "force killing $PID "
    for((i=0;i<=$KILL_TIMES;i++ ));do
        #kill instance for KILL_TIMES, each with KILL_INTERVAL secs
        kill -9 ${PID}
        sleep_Wait ${KILL_INTERVAL}
        if ! is_Instance_Alive ; then
            remove_Pid
            echo force kill successfully    #check if force kill of this round success
            return ${RET_SUCCESS}
        fi
    done
    echo shutdown failed, please manually check
    return ${RET_ERROR_SHUT}
    fi
}

#wait
function sleep_Wait(){
    local sec=$1
    for((i=1;i<=$sec;i++ ));do
        sleep 1
        echo -n "."
    done
    echo
}

#start up
function startup_Instance_Without_Nohup(){
##This function startup the instance
    if is_Instance_Alive; then
        echo no need to start, instance pid : ${PID}, exit
    else
        echo exec ${SEARCH_API_EXEC}
        echo -n "starting "
        ${SEARCH_API_EXEC}
    fi
}

function startup_Instance(){
##This function startup the instance
    if is_Instance_Alive; then
        echo no need to start, instance pid : ${PID}, exit
    else
        echo exec ${SEARCH_API_EXEC}
        echo -n "starting "
        nohup ${SEARCH_API_EXEC} > ${EXEC_STD_OUT} 2>&1 &
        if [ ! -z ${INSTANCE_PID} ];then
            echo $! > "${INSTANCE_PID}"
        fi
        sleep_Wait ${START_WAIT}
        if ! is_Instance_Alive ; then
            echo start successfully : `get_Pid`
            return ${RET_SUCCESS}
        else
            echo start failed
            return ${RET_ERROR_START}
        fi
    fi
}

#check instance status
function status_Instance(){
    if is_Instance_Alive;then
        echo "Instance is Alived, pid:${PID}"
        return ${RET_STATUS_ALIVE}
    else
        echo "Instance is not Alived"
        return ${RET_STATUS_NOT_ALIVE}
    fi
}

#dispatcher
function dispatcher(){
    if [ $# -lt 1 ] ;then
        usage
        exit -1
    fi
    if [ -z ${PROFILES} ];then
        echo "Please specific profiles before excute this script, example: export PROFILES=dev"
        exit -1
    fi

    local args=$1
    case "$args" in
    kill)
        kill_Instance
        ;;
    force)
        force_Instance
        ;;
    start)
        startup_Instance
        ;;
    fstart)
        startup_Instance_Without_Nohup
        ;;
    shutdown)
        kill_Instance
        ;;
    restart)
        shutdown_Instance && startup_Instance
        ;;
    status)
        status_Instance
        ;;
    *)
        usage
        ;;
    esac
}

dispatcher "$@"
#END
