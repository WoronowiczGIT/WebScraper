package models;

public class DataModel implements Data{
    private final String url;
    private final String time;

    private DataModel(DataModelBuilder modelBuilder) {
        this.url = modelBuilder.url;
        this.time = modelBuilder.time;
    }

    public String getUrl() {
        return url;
    }

    public String getTime() {
        return time;
    }


    public static class DataModelBuilder {
        private String url;
        private String time;

        public DataModelBuilder setUrl(String url){
            this.url = url;
            return this;
        }

        public DataModelBuilder setTime(String time){
            this.time = time;
            return this;
        }

        public DataModel build(){
            return new DataModel(this);
        }
    }


}
