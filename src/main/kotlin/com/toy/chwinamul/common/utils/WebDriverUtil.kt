package com.toy.chwinamul.common.utils

import com.toy.chwinamul.common.constant.WAIT_AMOUNT
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions


class WebDriverUtil {

    companion object {
        private const val WEBDRIVER_ID = "webdriver.chrome.driver"
        private const val WEBDRIVER_PATH = "/Users/mozylee/workspace/chwi-namul/chromedriver"

        fun getDriver(): ChromeDriver {
            System.setProperty(WEBDRIVER_ID, WEBDRIVER_PATH)

            val chromeOptions = ChromeOptions()
            chromeOptions.setBinary("")
            chromeOptions.addArguments("--headless")
            chromeOptions.addArguments("--remote-allow-origins=*")

            return ChromeDriver(chromeOptions)
        }
    }

}

inline fun <T> ChromeDriver.use(block: (ChromeDriver) -> T): T {
    val driver = this
    try {
        return block(driver)
    } finally {
        Thread.sleep(WAIT_AMOUNT)
        driver.quit()
    }
}