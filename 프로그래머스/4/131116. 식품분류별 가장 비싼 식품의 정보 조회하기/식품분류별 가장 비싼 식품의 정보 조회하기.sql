-- 코드를 입력하세요
SELECT fd.CATEGORY, fd.price as MAX_PRICE, fd.PRODUCT_NAME
from food_product fd join (select category, max(price) as price
                               from food_product
                               group by category
                               having category in ('과자', '국', '김치', '식용유')) as fd2
where fd.CATEGORY = fd2.category and fd.price = fd2.price
group by fd.category
order by MAX_PRICE desc