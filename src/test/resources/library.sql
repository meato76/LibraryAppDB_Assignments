
-- US 01
select count(id) from users; --
-- 2866

select count(distinct id) from users;
-- 2866


-- RESULT --> MANUALLY IT IS PASSED


-- US 02
select * from users;



-- US 03
select count(*) from book_borrow
where is_returned=0;

-- us03

select name from book_categories;

