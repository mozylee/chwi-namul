package com.toy.chwinamul.utils

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
            chromeOptions.addArguments("--headless",)
            chromeOptions.addArguments("--remote-allow-origins=*")

            return ChromeDriver(chromeOptions)
        }
    }

}