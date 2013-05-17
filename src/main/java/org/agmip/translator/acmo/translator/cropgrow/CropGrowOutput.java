/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agmip.translator.acmo.translator.cropgrow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.agmip.core.types.TranslatorOutput;
import static org.agmip.util.JSONAdapter.toJSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author qiuxiaolei
 */
public class CropGrowOutput  implements TranslatorOutput {
    private static final Logger log = LoggerFactory.getLogger(CropGrowOutput.class);
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void writeFile(String outputDirectory, Map data){
	try {
            String outputJson = outputDirectory+"/Agmip.wrg";
            File file = new File(outputJson);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(toJSON(data));
		bw.close();
		fw.close();
        } catch (IOException ex ) {
            log.error("Unable to generate Agmip.wrg");
            log.error(ex.toString());
	}
    }
    
}
