package com.github.barcodeeye.scan.result;

import android.content.Context;
import android.net.Uri;

import com.github.barcodeeye.scan.result.internal.IsbnResultProcessor;
import com.github.barcodeeye.scan.result.internal.ProductResultProcessor;
import com.github.barcodeeye.scan.result.internal.TextResultProcessor;
import com.github.barcodeeye.scan.result.internal.UriResultProcessor;
import com.google.zxing.Result;
import com.google.zxing.client.result.ISBNParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ProductParsedResult;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.client.result.URIParsedResult;

public final class ResultProcessorFactory {

    public static ResultProcessor<? extends ParsedResult> makeResultProcessor(
            Context context, Result result, Uri photoUri) {

        ParsedResult parsedResult = ResultParser.parseResult(result);


                return new TextResultProcessor(context, parsedResult, result, photoUri);
        
    }
}