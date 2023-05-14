package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.TablePage;

public class TableTest extends BaseTest{

    TablePage tablePage = new TablePage();

    @Test
    public void rowNumber()
    {
        tablePage.goToPaginationTable();

        int expected = 13;
        int actual = tablePage.countRows();

        Assertions.assertEquals(expected, actual);
    }
}
