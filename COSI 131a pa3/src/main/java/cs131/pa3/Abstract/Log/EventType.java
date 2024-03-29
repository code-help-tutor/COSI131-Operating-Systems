WeChat: cstutorcs
QQ: 749389476
Email: tutorcs@163.com
package cs131.pa3.Abstract.Log;

public enum EventType {
    ENTER_ATTEMPT("trying to enter"),
    ENTER_SUCCESS("entered successfully"),
    ENTER_FAILED("failed to enter"),
    LEAVE_START("leaving"),
    LEAVE_END("left"),
    COMPLETE("has completed"),
    ERROR("error in log"),
    END_TEST("end of test"),
    INTERRUPTED("interrupted");
            
    private final String name;

    private EventType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
