import org.json.simple.JSONObject;

public class JsonOut {
    public static void setJson(String site1, String site2, String name1, String name2, Double coef1, Double coef2, int stavka1, Double stavka2){
        JSONObject Json = new JSONObject();
        Json.put("site1",site1);
        Json.put("site2",site2);
        Json.put("name1",name1);
        Json.put("name2",name2);
        Json.put("coef1",coef1);
        Json.put("coef2",coef2);
        Json.put("stavka1",stavka1);
        Json.put("stavka2",stavka2);

        System.out.print(Json.toString());
    }
}
