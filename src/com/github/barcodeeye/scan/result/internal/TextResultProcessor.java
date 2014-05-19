package com.github.barcodeeye.scan.result.internal;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.github.barcodeeye.scan.api.CardPresenter;
import com.github.barcodeeye.scan.result.ResultProcessor;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;

public class TextResultProcessor extends ResultProcessor<ParsedResult> {

    private static final String TAG = TextResultProcessor.class.getSimpleName();

    private static final String SEARCH_URL = "https://www.google.com/search?q=%s";
    private static final String GRAPH_URL = "https://chart.googleapis.com/chart?chxt=x,y&chxl=0:%7CJan%7CFeb%7CMarch%7CApril%7CMay%7C1:%7CMin%7CMid%7CMax&cht=lc&chd=s:cEAELFJHHHKUju9uuXUc&chco=76A4FB&chls=2.0&chs=5&chf=c,s,000000|bg,s,000000&chs=470x270&&chco=ffffff";
    
    public TextResultProcessor(Context context, ParsedResult parsedResult,
            Result result, Uri photoUri) {
        super(context, parsedResult, result, photoUri);
    }

    @Override
    public List<CardPresenter> getCardResults() {
    	
    	
        List<CardPresenter> cardPresenters = new ArrayList<CardPresenter>();

        ParsedResult parsedResult = getParsedResult();
        
        
        String codeValue = parsedResult.getDisplayResult();

        int id = Integer.parseInt(codeValue);

        if (id == 5) {
        
        	CardPresenter cardPresenter = new CardPresenter();

            cardPresenters.add(cardPresenter);
        	
        } else if (id == 7) {
            
        	CardPresenter cardPresenter = new CardPresenter();
            //cardPresenter.setText("Show History").setFooter(codeValue);
        	
            cardPresenter.addImage(Uri.parse(GRAPH_URL));
            
            cardPresenters.add(cardPresenter);
        	
        }
        

        return cardPresenters;
    }

}
