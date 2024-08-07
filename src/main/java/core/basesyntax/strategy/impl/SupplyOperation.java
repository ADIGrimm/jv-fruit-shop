package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationException;

public class SupplyOperation implements Operation {
    private final StorageDao storageDao;

    public SupplyOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void proceed(FruitTransaction fruitTransaction) {
        if (storageDao.get(fruitTransaction.getFruitName()) == null) {
            throw new OperationException("Fruit " + fruitTransaction.getFruitName()
                    + " doesn't exist");
        }
        Fruit fruit = storageDao.get(fruitTransaction.getFruitName());
        fruit.setQuantity(fruit.getQuantity() + fruitTransaction.getQuantity());
    }
}
