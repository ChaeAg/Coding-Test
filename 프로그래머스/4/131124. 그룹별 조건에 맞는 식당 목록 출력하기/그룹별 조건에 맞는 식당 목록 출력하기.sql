SELECT mp.member_name, rr.review_text, DATE_FORMAT(rr.review_date, '%Y-%m-%d') AS REVIEW_DATE
FROM member_profile mp
JOIN rest_review rr
  ON mp.member_id = rr.member_id
JOIN (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    HAVING COUNT(*) = (
        SELECT MAX(cnt)
        FROM (
            SELECT member_id, COUNT(*) AS cnt
            FROM rest_review
            GROUP BY member_id
        ) t
    )
) x
  ON rr.member_id = x.member_id
ORDER BY rr.review_date, rr.review_text;