package Models;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author Harshana
 */
public class LUIS {

    private String Query;
    private String TopScoreIntent;
    private Double TopScoreIntentScore;
    private String SentimentAnalysisLabel;
    private Double SentimentAnalysisScore;
    
    private String EntityType1;
    private String EntityValue1;
    private Double EntityScore1;
    
    private String EntityType2;
    private String EntityValue2;
    private Double EntityScore2;
    
    private String EntityType3;
    private String EntityValue3;
    private Double EntityScore3;

    private String AppId = "8b2b20ad-49b4-4744-8f78-ac9078ee6c18";
    private String SubscriptionKey = "002eceea21cf47f491faa49c75596b36";

    public void ProcessQuery() {
        HttpClient httpclient = HttpClients.createDefault();

        try {

            URIBuilder builder
                    = new URIBuilder("https://westus.api.cognitive.microsoft.com/luis/v2.0/apps/" + AppId + "?");

            builder.setParameter("q", Query);
            builder.setParameter("timezoneOffset", "0");
            builder.setParameter("verbose", "true");    //if true return all intents
            builder.setParameter("spellCheck", "false");
            builder.setParameter("staging", "false");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", SubscriptionKey);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            String JsonResponse = EntityUtils.toString(entity);
            System.out.println(JsonResponse);   //print as a jsonString format
            JSONObject responseObject = new JSONObject(JsonResponse);   //convert JsonString to an object
            System.out.println(responseObject);   //print the response object

            int IntentsArraylength = responseObject.getJSONArray("intents").length();
            TopScoreIntent = responseObject.getJSONObject("topScoringIntent").get("intent").toString();
            TopScoreIntentScore = Double.parseDouble(responseObject.getJSONObject("topScoringIntent").get("score").toString());
            
            SentimentAnalysisLabel = responseObject.getJSONObject("sentimentAnalysis").get("label").toString();
            SentimentAnalysisScore = Double.parseDouble(responseObject.getJSONObject("sentimentAnalysis").get("score").toString());
            
            EntityType1 = responseObject.getJSONArray("entities").getJSONObject(0).get("type").toString();
            EntityValue1 = responseObject.getJSONArray("entities").getJSONObject(0).get("entity").toString();
            EntityScore1 = Double.parseDouble(responseObject.getJSONArray("entities").getJSONObject(0).get("score").toString());
            
            EntityType2 = responseObject.getJSONArray("entities").getJSONObject(1).get("type").toString();
            EntityValue2 = responseObject.getJSONArray("entities").getJSONObject(1).get("entity").toString();
            EntityScore2 = Double.parseDouble(responseObject.getJSONArray("entities").getJSONObject(1).get("score").toString());
            
            EntityType3 = responseObject.getJSONArray("entities").getJSONObject(2).get("type").toString();
            EntityValue3 = responseObject.getJSONArray("entities").getJSONObject(2).get("entity").toString();
            EntityScore3 = Double.parseDouble(responseObject.getJSONArray("entities").getJSONObject(2).get("score").toString());
            
            if (EntityScore1 == null) {
                System.out.println("EntityScore1 is null");
            } else {
                System.out.println("EntityType1 "+EntityType1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param Query the Query to set
     */
    public void setQuery(String Query) {
        this.Query = Query;
    }

    /**
     * @return the TopScoreIntent
     */
    public String getTopScoreIntent() {
        return TopScoreIntent;
    }

    /**
     * @return the TopScoreIntentScore
     */
    public Double getTopScoreIntentScore() {
        return TopScoreIntentScore;
    }

    /**
     * @return the SentimentAnalysisLabel
     */
    public String getSentimentAnalysisLabel() {
        return SentimentAnalysisLabel;
    }

    /**
     * @return the SentimentAnalysisScore
     */
    public Double getSentimentAnalysisScore() {
        return SentimentAnalysisScore;
    }

    /**
     * @return the EntityType1
     */
    public String getEntityType1() {
        return EntityType1;
    }

    /**
     * @return the EntityValue1
     */
    public String getEntityValue1() {
        return EntityValue1;
    }

    /**
     * @return the EntityScore1
     */
    public Double getEntityScore1() {
        return EntityScore1;
    }
    
        /**
     * @return the EntityType2
     */
    public String getEntityType2() {
        return EntityType2;
    }

    /**
     * @return the EntityValue2
     */
    public String getEntityValue2() {
        return EntityValue2;
    }

    /**
     * @return the EntityScore2
     */
    public Double getEntityScore2() {
        return EntityScore2;
    }

    /**
     * @return the EntityType3
     */
    public String getEntityType3() {
        return EntityType3;
    }

    /**
     * @return the EntityValue3
     */
    public String getEntityValue3() {
        return EntityValue3;
    }

    /**
     * @return the EntityScore3
     */
    public Double getEntityScore3() {
        return EntityScore3;
    }
}
