SELECT  coalesce(d.name, '总计') dept_name, coalesce(u.real_name, '整体') user_name, 
main.v1 '潜力', 
main.v2 '权限', 
main.v3 '增件', 
main.v4 '常态', 
main.v5 '暂停', 
main.v6 '停止' 
FROM
(
	SELECT depart.id did, user.id uid, 
	SUM(IF(p1.value='潜力',1,0)) AS v1,
	SUM(IF(p1.value='权限',1,0)) AS v2,
	SUM(IF(p1.value='增件',1,0)) AS v3,
	SUM(IF(p2.value='常态',1,0)) AS v4,
	SUM(IF(p2.value='暂停',1,0)) AS v5,
	SUM(IF(p2.value='停止',1,0)) AS v6
	FROM customer cu 
	INNER JOIN user ON user.id=cu.city_person_id
	INNER JOIN depart ON depart.id=user.depart_id
	LEFT JOIN param p1 ON cu.state_id=p1.id
	LEFT JOIN param p2 ON cu.stopped=p2.id
	GROUP BY depart.id, user.id WITH ROLLUP
) main
LEFT JOIN user u ON u.id=main.uid
LEFT JOIN depart d ON d.id=main.did
ORDER BY main.did, main.uid


-- SELECT coalesce(depart.name,user.real_name,'总计'), coalesce(user.real_name,'部门总计'),
-- SUM(IF(cu.state_id=58,1,0)) AS '潜力',
-- SUM(IF(cu.state_id=59,1,0)) AS '权限',
-- SUM(IF(cu.state_id=146,1,0)) AS '增件',
-- SUM(IF(cu.stopped=334,1,0)) AS '常态',
-- SUM(IF(cu.stopped=335,1,0)) AS '暂停',
-- SUM(IF(cu.stopped=540,1,0)) AS '停止'
-- FROM customer cu 
-- INNER JOIN user ON user.id=cu.city_person_id
-- INNER JOIN depart ON depart.id=user.depart_id
-- GROUP BY depart.name, user.real_name WITH ROLLUP
-- 