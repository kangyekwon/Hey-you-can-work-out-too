# 필요한 라이브러리 불러오기
from selenium import webdriver
from urllib.request import urlopen
from selenium.webdriver.common.keys import Keys
import time
import urllib.request
import os

# 1. 이미지 저장할 폴더 생성
if not os.path.isdir("smith_machine/"):
    os.makedirs("smith_machine/")

# 2. 크롬 웹드라이버 연결
driver = webdriver.Chrome()
driver.get("https://www.google.com/imghp?hl=ko&tab=8i")

search = "smith machine"
elem = driver.find_element_by_name("q")
elem.send_keys(search)
elem.send_keys(Keys.RETURN)

# 4. 스크롤 끝까지 내리기
SCROLL_PAUSE_TIME = 1

last_height = driver.execute_script("return document.body.scrollHeight")

while True:
    driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
    time.sleep(SCROLL_PAUSE_TIME)
    new_height = driver.execute_script("return document.body.scrollHeight")

    if new_height == last_height:
        try:
            driver.find_element_by_css_selector(".mye4qd").click()
        except:
            break
    last_height = new_height

# 5. 이미지 찾아서 원본 파일로 저장하기
images = driver.find_elements_by_css_selector(".rg_i.Q4LuWd")
count = 1

for image in images:
    try:
        image.click()
        time.sleep(2)
        imgUrl = driver.find_element_by_xpath('//*[@id="Sva75c"]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[1]/div[3]/div/a/img').get_attribute("src")
        urllib.request.urlretrieve(imgUrl, "smith_machine/" + search + "_" + str(count) + ".jpg")
        print("Image saved: smith_machine_{}.jpg".format(count))
        count += 1
    except:
        pass

driver.close()