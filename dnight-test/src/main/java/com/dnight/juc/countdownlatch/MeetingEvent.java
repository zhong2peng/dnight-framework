package com.dnight.juc.countdownlatch;

/**
 * @author ZHONGPENG769
 * @date 2019/7/31
 */
public class MeetingEvent {

    public static void main(String[] args) {
        VideoConference conference = new VideoConference(10);
        Thread threadConfenerce = new Thread(conference);
        threadConfenerce.start();
        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(conference, "participant" + i);
            new Thread(participant).start();
        }
    }
}
