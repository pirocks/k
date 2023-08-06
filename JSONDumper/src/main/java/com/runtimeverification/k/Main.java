package com.runtimeverification.k;

import org.kframework.kompile.CompiledDefinition;
import org.kframework.unparser.ToJson;
import org.kframework.utils.BinaryLoader;

import javax.json.JsonStructure;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        final BinaryLoader loader = new BinaryLoader(null);
        final String file_to_dump = args[0];
        final CompiledDefinition compiledDefinition = loader.loadOrDie(CompiledDefinition.class, new File(file_to_dump));
        final JsonStructure json = ToJson.toJson(compiledDefinition.kompiledDefinition);
        System.out.println(json.toString());
    }
}