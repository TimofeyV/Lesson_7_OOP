package Views;

import java.util.List;

public interface View {
    int get();
    void set(String value);
    void appendLog(String log);
    public void appendLog(List list);
    void showLog();
}