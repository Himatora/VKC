package view;

public class StatsTable {
    private int id;
    private String type;
    private String result;
    public StatsTable(int id,String type,String result)
    {
        this.setId(id);
        this.setType(type);
        this.setResult(result);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }

    public String getResult() {
        return result;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
