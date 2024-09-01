import java.applet.AudioClip;
import java.util.Scanner;

public class AlarmClock {
    private static boolean isAlarmRunning = false;
    private static boolean haveBreak = true;
    private static AudioClip clip = java.applet.Applet.newAudioClip(AlarmClock.class.getResource("alarmSound.wav"));

    public void start() {
        Scanner scanner = new Scanner(System.in);
        AlarmClock alarmClock = new AlarmClock();
        while (true) {
            if (isAlarmRunning) {
                System.out.println("按回车关闭闹钟");
                if (scanner.nextLine().isEmpty()) {
                    isAlarmRunning = false;
                }
            } else {
                if (!haveBreak) {
                    System.out.println("开始休息");
                    try {
                        Thread.sleep(1000 * 20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    alarmClock.alarm();
                    System.out.println("按回车结束休息");
                    if (scanner.nextLine().isEmpty()) {
                        alarmClock.stopAlarm();
                    }
                    System.out.println("按回车开始工作");
                    if (scanner.nextLine().isEmpty()) {
                        haveBreak = true;
                    }
                } else {
                    System.out.println("开始工作");
                    try {
                        Thread.sleep(1000 * 20 * 60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    alarmClock.alarm();
                    System.out.println("按回车结束工作");
                    if (scanner.nextLine().isEmpty()) {
                        alarmClock.stopAlarm();
                    }
                    System.out.println("按回车开始休息");
                    if (scanner.nextLine().isEmpty()) {
                        haveBreak = false;
                    }
                }
            }
        }
    }

    private void alarm() {
        // 播放声音
        clip.loop();
    }

    private void stopAlarm() {
        clip.stop();
    }
}


