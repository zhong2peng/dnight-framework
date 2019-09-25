# Q:
Given a text file file.txt, transpose its content.

You may assume that each row has the same number of columns and each field is separated by the ' ' character.

Example:

If file.txt has the following content:

name age
alice 21
ryan 30
Output the following:

name alice ryan
age 21 30

# A:
awk '
{
    for(i = 1; i<=NF; i++){
        if(FNR == 1){
            t[i] = $i;
        }else{
            t[i] = t[i] " " $i
        }
    }
}
END {
    for(i = 1; t[i] != ""; i++){
        print t[i]
    }
}
' file.txt