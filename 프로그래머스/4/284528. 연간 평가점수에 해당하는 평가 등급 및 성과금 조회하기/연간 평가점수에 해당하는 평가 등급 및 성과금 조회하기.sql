SELECT HE.EMP_NO, EMP_NAME, GRADE, CASE GRADE
                                        WHEN 'S' THEN SAL * 0.2
                                        WHEN 'A' THEN SAL * 0.15
                                        WHEN 'B' THEN SAL * 0.1
                                        ELSE 0
                                    END BONUS
FROM HR_DEPARTMENT HD, HR_EMPLOYEES HE, 
    (SELECT EMP_NO, CASE 
                        WHEN AVG(SCORE) >= 96 THEN 'S'
                        WHEN AVG(SCORE) >= 90 THEN 'A'
                        WHEN AVG(SCORE) >= 80 THEN 'B'
                        ELSE 'C'
                    END GRADE FROM HR_GRADE GROUP BY EMP_NO) HG
WHERE HD.DEPT_ID = HE.DEPT_ID AND HE.EMP_NO = HG.EMP_NO
ORDER BY HE.EMP_NO