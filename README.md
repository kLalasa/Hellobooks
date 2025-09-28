# HelloBooks UI Automation Suite

## **UI Automation using Selenium WebDriver**

### **Tech Stack Used**
- **Java** – Core programming language for automation.  
- **Selenium WebDriver** – Browser automation.  
- **Maven** – Build tool and dependency management.  
- **TestNG** – Test execution, organization, and assertions.  
- **Page Object Model (POM) + Page Factory** – Structured page interactions for maintainability.  
- **Allure Reports / Screenshot Capture** – Rich HTML reports and visual evidence of test execution.  

---

## **Project Details**
This project automates **key functionalities of HelloBooks**, a finance/accounting SaaS application, focusing on **Login, Signup, Onboarding, and basic security validations** using a **robust hybrid framework**.  

**Application Under Test (UAT):**  
[https://dev.hellobooks.ai/](https://dev.hellobooks.ai/)


---

## **Framework Overview**
- **Page Object Model (POM)** to maintain modular page interactions.  
- Base class handles WebDriver setup, teardown, and screenshot capture.  
- All tests organized using **TestNG** with priorities.  
- Screenshots captured automatically after key steps or failures.  

---

## **Data Management**
- Test data stored in **config.properties**.  
- OTP is stubbed for automation; real email OTP optional via disposable inbox (Mailinator).  
- Unique emails generated for signup: `qa.automation+<timestamp>@example.com`  

---

## **Reporting**
- **Allure Reports** provide detailed HTML reports with test status and screenshots.  




