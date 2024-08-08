package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<FruitOperation> parse(List<String[]> lines) {
        List<FruitOperation> commands = new ArrayList<>();
        for (String[] line : lines) {
            if (line.length != 3) {
                throw new RuntimeException("Can't parse information from " + Arrays.toString(line));
            }
            FruitOperation fruitOperation = new FruitOperation(
                    FruitOperation.Operation.getFromCode(line[0]),
                    line[1],
                    Integer.parseInt(line[2])
            );
            commands.add(fruitOperation);
        }
        return commands;
    }
}
