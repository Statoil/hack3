package com.github.barcodeeye.scan.result.internal;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.github.barcodeeye.R;
import com.github.barcodeeye.scan.api.CardPresenter;
import com.github.barcodeeye.scan.result.ResultProcessor;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;

public class TextResultProcessor extends ResultProcessor<ParsedResult> {

    private static final String TAG = TextResultProcessor.class.getSimpleName();

    private static final String SEARCH_URL = "https://www.google.com/search?q=%s";

    public TextResultProcessor(Context context, ParsedResult parsedResult,
            Result result, Uri photoUri) {
        super(context, parsedResult, result, photoUri);
    }

    @Override
    public Intent getCardResults() {

        ParsedResult parsedResult = getParsedResult();
        
        String codeValue = parsedResult.getDisplayResult();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(codeValue));

        return browserIntent;
    }

}
