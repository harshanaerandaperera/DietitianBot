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

public class LUIS {

    private String Query;
    private String TopScoreIntent;
    private Double TopScoreIntentScore;
    private String SentimentAnalysisLabel;
    private Double SentimentAnalysisScore;
    
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
            //System.out.println(JsonResponse);   //print as a jsonString format
            JSONObject responseObject = new JSONObject(JsonResponse);   //convert JsonString to an object
            System.out.println(responseObject);   //print the response object

            int IntentsArraylength = responseObject.getJSONArray("intents").length();
            TopScoreIntent = responseObject.getJSONObject("topScoringIntent").get("intent").toString();
            TopScoreIntentScore = Double.parseDouble(responseObject.getJSONObject("topScoringIntent").get("score").toString());
            SentimentAnalysisLabel = responseObject.getJSONObject("sentimentAnalysis").get("label").toString();
            SentimentAnalysisScore = Double.parseDouble(responseObject.getJSONObject("sentimentAnalysis").get("score").toString());


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
}
