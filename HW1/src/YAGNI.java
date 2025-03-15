/*import java.util.*;
import java.text.*;
public class YAGNI{
private List<String> history=new ArrayList<>();
public String processData(String data){if(data==null)return""; String s=data.trim(); log("Basic: "+s); return s;}
public String processDataWithEncryption(String data){
    String s=encrypt(data);log("Encryption: "+s);
    return s;
}
public String processDataWithCompression(String data){
    String s = compress(data);log("Compression: "+s);return s;}
public String processDataWithAnalytics(String data)
{
    Map<String,Integer> a = analytics(data);   String s = data+"|"+a.toString();log("Analytics: "+s);
    return s;}
public String processDataFull(String data){
String e = encrypt(data);
                  String c = compress(e);
Map<String,Integer> a = analytics(c);
String s = format(c, a);
log("Full Process: "+s);
        return s;
}
private String encrypt(String data){return new StringBuilder(data).reverse().toString();
}
private String compress(String data){return data.replaceAll("[AEIOUaeiou]","");
}
private Map<String,Integer> analytics(String data){
    Map<String,Integer> m = new HashMap<>();int l=0, d=0;
    for(char ch : data.toCharArray()){
        if(Character.isLetter(ch)) l++;else if(Character.isDigit(ch)) d++;}
    m.put("letters", l);m.put("digits", d);
    return m;
}
private String format(String data, Map<String,Integer> a){
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");String date=df.format(new Date());return "On "+date+" processed: "+data+" | analytics: "+a;
}
private void log(String msg){history.add(msg);}
public List<String> getHistory(){return history;}
}*/

import java.util.*;

// used better naming and included spacing and indentation
// kept only necessary functionalities, namely only logging data, and getting the logs, the rest are just extra and unnecessary
// our class is just a basic logger, and thus requires only saving the logs; encryption, compression and the rest are unnecessary, since we need to logs in their entirety for manual analysis
public class YAGNI {
    private List<String> historyLog = new ArrayList<>();

    private void log(String msg) {
        historyLog.add(msg);
    }

    public List<String> getHistory() {
        return historyLog;
    }

    public String processData(String data) {
        if (data == null) {
            return "";
        }

        String trimmedData = data.trim();
        log("Basic: " + trimmedData);

        return trimmedData;
    }

}