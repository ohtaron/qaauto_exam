package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultPage;
import page.SecondSearchResultPage;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void googleSearchTest() {
        String searchTerm = "Selenium";


    Assert.assertTrue(searchPage.isPageLoaded(),
            "Search page was not loaded.");

    SearchResultPage searchResultPage = searchPage.search(searchTerm);

        Assert.assertTrue(searchResultPage.isPageLoaded(),
                "SearchResults page was not loaded.");

        List<String> searchResults = searchResultPage.getSearchResults();

        Assert.assertEquals(searchResultPage.getSearchResultsCount(), 9,
                "Results count is wrong.");

        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "searchTerm: " + searchTerm + " not found in: \n" + searchResult);
        }

        SecondSearchResultPage secondSearchResultPage = searchResultPage.changeToSecondPage();

        Assert.assertTrue(searchResultPage.isPageLoaded(),
                "SearchResults page was not loaded.");

        List<String> secondSearchResults = secondSearchResultPage.getSearchResults();

        Assert.assertEquals(secondSearchResultPage.getSearchResultsCount(), 10,
                "Results count is wrong.");

        for (String searchResult : secondSearchResults) {
            Assert.assertTrue(searchResult.contains(searchTerm.toLowerCase()),
                    "searchTerm: " + searchTerm + " not found in: \n" + searchResult);
        }


    }
}
