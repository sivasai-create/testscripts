import pytest
from selenium import webdriver
from webdrivermanager import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys


@pytest.fixture(scope="module")
def browser():
    # Initialize the Chrome WebDriver
    driver = webdriver.Chrome(ChromeDriverManager().install())
    driver.maximize_window()
    yield driver
    driver.quit()


def test_makemytrips(browser: ChromeDriverManager):
    browser.get("https://www.makemytrip.com/")
    wait = WebDriverWait(browser, 10)
    popup_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//span[@class='commonModal__close']")))
    popup_button.click()
    flights_button = wait.until(EC.visibility_of_element_located((By.XPATH, "//span[text()='Flights']")))
    flights_button.click()
    round_trip_button = wait.until(EC.visibility_of_element_located((By.XPATH, "//li[text()='Round Trip']")))
    round_trip_button.click()
    from_input = wait.until(EC.visibility_of_element_located((By.XPATH, "//span[text()='From']")))
    from_input.click()
    from_city = wait.until(EC.visibility_of_element_located((By.XPATH, "//input[@placeholder='From']")))
    from_city.send_keys("HYD")
    from_select_city = wait.until(EC.element_to_be_clickable((By.XPATH, "//p[text()='Hyderabad, India']")))
    from_select_city.click()
    to_input = wait.until(EC.visibility_of_element_located((By.XPATH, "//span[text()='To']")))
    to_input.click()
    to_city = wait.until(EC.visibility_of_element_located((By.XPATH, "//input[@placeholder='To']")))
    to_city.send_keys("MAA")
    to_select_city = wait.until(EC.element_to_be_clickable((By.XPATH, "//p[text()='Chennai, India']")))
    to_select_city.click()
    departure_date_input = wait.until(EC.element_to_be_clickable((By.XPATH, "//div[@aria-label='Wed Oct 25 2023']")))
    departure_date_input.click()
    return_date_input = wait.until(EC.element_to_be_clickable((By.XPATH, "//div[@aria-label='Sat Nov 04 2023']")))
    return_date_input.click()
    search_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//a[text()='Search']")))
    search_button.click()
    wait.until(EC.title_contains("MakeMyTrip"))
    assert "MakeMyTrip" in browser.title

if __name__ == "__main__":
    pytest.main()
