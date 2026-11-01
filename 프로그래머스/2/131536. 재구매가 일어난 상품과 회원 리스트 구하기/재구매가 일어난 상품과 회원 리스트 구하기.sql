-- 코드를 입력하세요
SELECT user_id, product_id
from online_sale
group by user_id, product_id
having count(*) > 1
order by USER_ID ASC, PRODUCT_ID DESC;



