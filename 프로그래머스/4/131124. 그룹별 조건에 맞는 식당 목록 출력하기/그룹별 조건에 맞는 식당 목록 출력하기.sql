SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, "%Y-%m-%d") REVIEW_DATE
FROM REST_REVIEW RR, (SELECT MEMBER_ID, COUNT(REST_ID) C 
                      FROM REST_REVIEW 
                      GROUP BY MEMBER_ID 
                      ORDER BY C DESC
                      LIMIT 1) N, MEMBER_PROFILE MP
WHERE RR.MEMBER_ID = MP.MEMBER_ID AND RR.MEMBER_ID = N.MEMBER_ID
ORDER BY REVIEW_DATE, REVIEW_TEXT