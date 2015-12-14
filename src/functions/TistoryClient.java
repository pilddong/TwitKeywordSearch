package functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
/**
 * @see "http://www.tistory.com/guide/api/post"
 * API 占쎈굝�ｏ옙�볦삕占쎈눴tp://twitiwt.tistory.com/api ID1955909占쎌쥙�ο㎖猷잜룕占쎈굞�뺝뜝�뚮닔�곕냲�숋옙�뽮뎄占쎈맮�숃눧�듐룄占쏀꼫HYXG7
 */
public class TistoryClient {
	private static final String ACCESS_TOKEN = "0a32bc282c3d7b45380a599dc8260d89_fcba3b2fb06751d5782bf2c59645d96d";

    private static final String CLIENT_ID = "552841ab0fef581d89d5d79282216340";
    private static final String SECRET_KEY = "552841ab0fef581d89d5d7928221634091bc68e95c3b22a5a6fcc70ec0708693adf15709";
    private static final String REDIRECT_URI = "http://localhost:8080/TwitterMiningEngine/result.jsp";

    private static final String TARGET_URL = "twitiwt";
    private static final String WRITE_API_URL = "https://www.tistory.com/apis/post/write";
    private static final String MODIFY_API_URL = "https://www.tistory.com/apis/post/modify";
    private static final String CATEGORY_LIST_API_URL = "https://www.tistory.com/apis/category/list";

    // �좎럥�뷂옙�⑼옙�좎뜾�억옙�깆굲占쎈맦由울옙醫묒삕占썬뀼逾�    
    private static final String DONATE = "<iframe src=\"http://gift.blog.daum.net/widget?entryId=0&amp;setNo=2043\" width=\"100%\" height=\"250\" frameborder=\"0\" border=\"0\" scrolling=\"no\" allowtransparency=\"true\" ;=\"\"></iframe>";

    private static final String OUTPUT = "json";

    private static final String GAME_CATEGORY = "607233";

    private static final String USER_AGENT = "Mozilla/5.0";

    public void getAccessToken() {
    	String clientId = "552841ab0fef581d89d5d79282216340";
        String clientSecret = "552841ab0fef581d89d5d7928221634091bc68e95c3b22a5a6fcc70ec0708693adf15709";
        String redirectUri = "http://168.131.153.174:8080/TwitterMiningEngine/result.jsp";
        String grantType = "authorization_code";

//        String requestUrl = "https://www.tistory.com/oauth/access_token/?code=" + authorization_code +
//                "&client_id=" + CLIENT_ID +
//                "&client_secret=" + SECRET_KEY +
//                "&redirect_uri=" + REDIRECT_URI +
//                "&grant_type=" + grantType;
    }
    /**
     * write tistory article
     * @param tistoryBrainDotsArticle
     */
    public void write(TistoryBrainDotsArticle tistoryBrainDotsArticle) throws IOException {
        // common validation check
        checkCommonValidation(tistoryBrainDotsArticle);

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(WRITE_API_URL);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        // String title = "�좎럥留㏆옙占쎌삕占쎈맩�뺧옙醫롫짗占쎌늺伊덌옙�レ쉐 占쎌쥙�ワ옙�곗삕沃섓옙�뺝뜝�꾨궡占쏙옙" + tistoryBrainDotsArticle.getStage() + " 占쎌쥙�ε뜝�숈삕�⑥궡�뺧옙醫롫짗占쎌닂�숋옙���占쎌쥙猷욑옙占�       
        String title = tistoryBrainDotsArticle.getTitle();


        String content = tistoryBrainDotsArticle.getContent();
       
        String category = tistoryBrainDotsArticle.getCategory();
       
        //        "<h2>�좎럥留㏆옙占쎌삕占쎈맩�뺧옙醫롫짗占쎌늺伊덌옙�レ쉐 占쎌쥙�ワ옙�곗삕沃섓옙�뺝뜝�꾨궡占쏙옙" + tistoryBrainDotsArticle.getTitle() + " 占쎌쥙�ε뜝�숈삕�⑥궡�뺧옙醫묒삕h2>" +
        //                "<div>" + tistoryBrainDotsArticle.getYoutube() + "</div>\n" +
        //                "<div>" + tistoryBrainDotsArticle.getStrategy() + "</div>\n" +
        //                "<div>" + DONATE + "</div>\n";

        //Set<String> tagSets = getBrainDotsTags();

        //tagSets.add(tistoryBrainDotsArticle.getTitle());

        //String tags = Joiner.on(",").join(tagSets);
        String tags = tistoryBrainDotsArticle.getTag();
        System.out.println(tags);

        List urlParameters = Lists.newArrayList();
        urlParameters.add(new BasicNameValuePair("access_token", ACCESS_TOKEN));
        urlParameters.add(new BasicNameValuePair("targetUrl", TARGET_URL)); // 占쎄퀣�わ옙醫듼봺 雅뚯눘�� http://xxx.tistory.com 占쎌눊瑗랃옙占퐔xx 筌랃옙占쎈굝�� 2筌△뫀猷꾬쭖遺우뵥占쏙옙野껋럩��http://占쎌뮄援낉옙占퐑rl 占쎈굝��       
        urlParameters.add(new BasicNameValuePair("output", OUTPUT));    // output type

        urlParameters.add(new BasicNameValuePair("title", title));  // 占쎌뮆��        
        urlParameters.add(new BasicNameValuePair("content", content));  // 占쎈똻��       
        urlParameters.add(new BasicNameValuePair("category", category));   // 燁삳똾�믤�醫듼봺
        urlParameters.add(new BasicNameValuePair("tag", tags)); // 占쎌뮄��        
        if (tistoryBrainDotsArticle.getVisibility() != null) {
            urlParameters.add(new BasicNameValuePair("visibility", tistoryBrainDotsArticle.getVisibility()));
            System.out.println(tistoryBrainDotsArticle.getVisibility());
        }

        post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));

        HttpResponse response = client.execute(post);

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
    }

    /*
    public void modify(TistoryBrainDotsArticle tistoryBrainDotsArticle) throws Exception {
        // validation check for modify
        if (tistoryBrainDotsArticle.getPostId() == null) {
            throw new RuntimeException("postId needed");
        }

        // common validation check
        checkCommonValidation(tistoryBrainDotsArticle);


        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(MODIFY_API_URL);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        String title = "�좎럥留㏆옙占쎌삕占쎈맩�뺧옙醫롫짗占쎌늺伊덌옙�レ쉐 占쎌쥙�ワ옙�곗삕沃섓옙�뺝뜝�꾨궡占쏙옙" + tistoryBrainDotsArticle.getStage() + " 占쎌쥙�ε뜝�숈삕�⑥궡�뺧옙醫롫짗占쎌닂�숋옙���占쎌쥙猷욑옙占�
       String content =
                "<h2>�좎럥留㏆옙占쎌삕占쎈맩�뺧옙醫롫짗占쎌늺伊덌옙�レ쉐 占쎌쥙�ワ옙�곗삕沃섓옙�뺝뜝�꾨궡占쏙옙" + tistoryBrainDotsArticle.getStage() + " 占쎌쥙�ε뜝�숈삕�⑥궡�뺧옙醫묒삕h2>" +
                "<div>" + tistoryBrainDotsArticle.getYoutube() + "</div>" +
                "<div>" + tistoryBrainDotsArticle.getStrategy() + "</div>" +
                "<div>" + DONATE + "</div>\n";

        Set<String> tagSets = getBrainDotsTags();

        tagSets.add(tistoryBrainDotsArticle.getStage());

        String tags = Joiner.on(",").join(tagSets);

        List urlParameters = Lists.newArrayList();
        urlParameters.add(new BasicNameValuePair("access_token", ACCESS_TOKEN));
        urlParameters.add(new BasicNameValuePair("targetUrl", TARGET_URL)); //
        urlParameters.add(new BasicNameValuePair("title", title));  // 占쎌쥙�⑵짆�낆삕�좑옙       urlParameters.add(new BasicNameValuePair("content", content));  // 占쎌쥙�ο옙�쇱삕�좑옙       urlParameters.add(new BasicNameValuePair("category", GAME_CATEGORY));   // 占쎄낯沅좑옙�듭삕沃섅끏�숋옙�ル깼�딉옙        urlParameters.add(new BasicNameValuePair("tag", tags)); // 占쎌쥙�⑵짆袁ъ삕�좑옙       urlParameters.add(new BasicNameValuePair("output", OUTPUT));    // output type

        urlParameters.add(new BasicNameValuePair("postId", tistoryBrainDotsArticle.getPostId()));   // only modify

        post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));

        HttpResponse response = client.execute(post);

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
    }
    */

    protected void checkCommonValidation(TistoryBrainDotsArticle tistoryBrainDotsArticle) {
       /* if (tistoryBrainDotsArticle.getYoutube() == null) {
            throw new RuntimeException("youtube needed");
        }

        if (tistoryBrainDotsArticle.getStage() == null) {
            throw new RuntimeException("stage needed");
        }

        if (tistoryBrainDotsArticle.getStrategy() == null) {
            throw new RuntimeException("strategy needed");
        }
        */
        
        if (tistoryBrainDotsArticle.getTitle() == null) {
            throw new RuntimeException("title needed");
        }
        if (tistoryBrainDotsArticle.getContent() == null) {
            throw new RuntimeException("content needed");
        }
    }


    /**
     * brain dots tags
     * @return tags set
     */
    private Set<String> getBrainDotsTags() {
        Set<String> tagSets = Sets.newHashSet();
        tagSets.add("�좎럥留㏆옙占쎌삕占쎈맩�뺟춯琉얩뜐筌앷엥�앾옙�덉굲");
        tagSets.add("braindots");
        tagSets.add("brain dots");
        tagSets.add("占쎈―�볩옙節륁삕�좑옙");
        tagSets.add("game");
        tagSets.add("占쎌쥙�⑼옙�뉖윺�좑옙");
        tagSets.add("puzzle");
        tagSets.add("�좎뜦維�린�듭삕�좑옙");
        tagSets.add("strategy");
        tagSets.add("占쎌쥙�ε뜝�숈삕�⑥궡�뺧옙醫묒삕");
        tagSets.add("clear");
        tagSets.add("�좎럥占쏙㎖�곗삕�좑옙");
        tagSets.add("brain");

        return tagSets;
    }

    /**
     * get category list
     * @throws IOException
     */
    public void categoryList() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        String output = "json";
        HttpGet request = new HttpGet(CATEGORY_LIST_API_URL + "?access_token=" + ACCESS_TOKEN + "&targetUrl=" + TARGET_URL + "&output=" + output);

        // add header
        request.setHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
    }
}