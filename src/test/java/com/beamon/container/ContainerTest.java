package com.beamon.container;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContainerTest {
    private Container oneThousandLitreContainer;
    private Container tenThousandLitreContainer;
    private Container bathtub;

    private final static int ZERO = 0;
    private final static int ONE_THOUSAND = 1000;
    private final static int EIGHT_THOUSAND = 8000;
    private final static int NINE_THOUSAND = 9000;
    private final static int TEN_THOUSAND = 10000;
    private final static int INT_MAX = Integer.MAX_VALUE;

    @Before
    public void setup() {
        oneThousandLitreContainer = new Container(ONE_THOUSAND, ZERO, ContainerType.BOTTLE);
        tenThousandLitreContainer = new Container(TEN_THOUSAND, ZERO, ContainerType.BOTTLE);
        bathtub = Container.Bathtub();
    }

    @Test
    public void testBathtub() {
        assertEquals(INT_MAX, bathtub.getCapacity());
        assertEquals(INT_MAX, bathtub.getLevel());

        oneThousandLitreContainer.fillWithFluidFromContainer(bathtub);

        assertEquals(INT_MAX, bathtub.getCapacity());
        assertEquals(INT_MAX, bathtub.getLevel());
    }

    @Test
    public void testContainerCapacity() {
        assertEquals(ONE_THOUSAND, oneThousandLitreContainer.getCapacity());

        oneThousandLitreContainer.fillWithFluidFromContainer(bathtub);

        assertEquals(ONE_THOUSAND, oneThousandLitreContainer.getCapacity());

        tenThousandLitreContainer.fillWithFluidFromContainer(oneThousandLitreContainer);

        assertEquals(ONE_THOUSAND, oneThousandLitreContainer.getCapacity());
        assertEquals(TEN_THOUSAND, tenThousandLitreContainer.getCapacity());

        tenThousandLitreContainer.fillWithFluidFromContainer(bathtub);

        assertEquals(ONE_THOUSAND, oneThousandLitreContainer.getCapacity());
        assertEquals(INT_MAX, bathtub.getCapacity());

        oneThousandLitreContainer.fillWithFluidFromContainer(tenThousandLitreContainer);

        assertEquals(ONE_THOUSAND, oneThousandLitreContainer.getLevel());
        assertEquals(TEN_THOUSAND, tenThousandLitreContainer.getCapacity());

    }

    @Test
    public void testContainerLevel() {
        assertEquals(ZERO, oneThousandLitreContainer.getLevel());

        oneThousandLitreContainer.fillWithFluidFromContainer(bathtub);

        assertEquals(oneThousandLitreContainer.getCapacity(), oneThousandLitreContainer.getLevel());

        tenThousandLitreContainer.fillWithFluidFromContainer(oneThousandLitreContainer);

        assertEquals(ZERO, oneThousandLitreContainer.getLevel());
        assertEquals(ONE_THOUSAND, tenThousandLitreContainer.getLevel());

        tenThousandLitreContainer.fillWithFluidFromContainer(bathtub);
        oneThousandLitreContainer.fillWithFluidFromContainer(tenThousandLitreContainer);

        assertEquals(ONE_THOUSAND, oneThousandLitreContainer.getLevel());
        assertEquals(NINE_THOUSAND, tenThousandLitreContainer.getLevel());

        oneThousandLitreContainer.empty();

        assertEquals(ZERO, oneThousandLitreContainer.getLevel());

        oneThousandLitreContainer.fillWithFluidFromContainer(tenThousandLitreContainer);

        assertEquals(ONE_THOUSAND, oneThousandLitreContainer.getLevel());
        assertEquals(EIGHT_THOUSAND, tenThousandLitreContainer.getLevel());
    }
}
