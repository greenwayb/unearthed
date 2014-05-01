SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists audit;

drop table if exists bar;

drop table if exists match_user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists audit_seq;

drop sequence if exists bar_seq;

drop sequence if exists match_user_seq;

