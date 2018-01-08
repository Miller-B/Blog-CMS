/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.ApplicationContextHelper.TestingDataInjector;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author EJB Laptop
 */
public class TestingDataInjector {
    
    private JdbcTemplate jdbcTemplate;

    public TestingDataInjector(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
        
    private static final String[] INSERT_DATA = {
        
        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(1, 'News')",

        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(2, 'Sports')",

        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(3, 'Travel')",

        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(4, 'Promotions')",

        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(5, 'Food')",

        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(6, 'Education')",

        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(7, 'Jokes')",

        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(8, 'Puzzles')",

        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(9, 'Social Media')",

        "INSERT INTO BlogDatabaseTest.categories (categoryId, categoryName) VALUES(10, 'Antisocial Media')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(1, '#trashtag')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(2, '#currentlytrendingintagland')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(3, '#grandmasdoilies')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(4, '#omginternetmemeroflcopter')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(5, '#cardboardpanels')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(6, '#hastagyoureit')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(7, '#rumplestiltskin')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(8, '#tencentsoffallrutabagas')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(9, '#gatistagspelledbackwards')",

        "INSERT INTO BlogDatabaseTest.hashtags (hashtagId, tagName) VALUES(10, '#dontclickmeseriouslydont')",

        "INSERT INTO BlogDatabaseTest.roles(roleId, roleName) VALUES(1, 'admin')",

        "INSERT INTO BlogDatabaseTest.roles(roleId, roleName) VALUES(2, 'poster')",

        "INSERT INTO BlogDatabaseTest.roles(roleId, roleName) VALUES(3, 'user')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(1, 'About Us', 'We are the champions, my friends, And we''ll keep on fighting ''til the end. We are the champions. We are the champions. No time for losers ''cause we are the champions of the world.')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(2, 'About Me', 'See me ride out of the sunset on your color TV screen. Out for all that I can get, if you know what I mean. Women to the left of me, and women to the right. Ain''t got no gun, Ain''t got no knife. Don''t you start no fight. ''Cause I''m T.N.T. I''m dynamite. T.N.T. and I''ll win the fight. T.N.T. I''m a power load. T.N.T. watch me explode. I''m dirty, mean and mighty unclean I''m a wanted man. Public enemy number one. Understand. So lock up your daughter. Lock up your wife. Lock up your  back door. And run for your life. The man is back in town. Don''t you mess me ''round. ''Cause I''m T.N.T. I''m dynamite. T.N.T. and I''ll win the fight. T.N.T.')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(3, 'About Them', 'You show us everything you''ve got. You keep on dancin'' and the room gets hot. You drive us wild, we''ll drive you crazy. You say you wanna go for a spin. The party''s just begun, we''ll let you in. You drive us wild, we''ll drive you crazy. You keep on shoutin'', you keep on shoutin''. I wanna rock and roll all night and party every day. I wanna rock and roll all night and party every day. You keep on saying you''ll be mine for a while. You''re lookin''  fancy and I like your style. You drive us wild, we''ll drive you crazy. You show us everything you''ve got. Baby, baby that''s quite a lot. And you drive us wild, we''ll drive you crazy.You keep on shoutin'', you keep on shoutin''')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(4, 'About Her', 'She was a fast machine. She kept her motor clean. She was the best damn woman I had ever seen. She had the sightless eyes. Telling me no lies. Knockin'' me out with those American thighs. Taking more than her share. Had me fighting for air. She told me to come but I was already there'' Cause the walls start shaking. The earth was quaking. My mind was aching. And we were making it and you, shook me all night long. Yeah you shook me all night long.')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(5, 'About Him', 'Can''t stop, addicted to the shindig. Chop Top, he says I''m gonna win big. Choose not a life of imitation. Distant cousin to the reservation. Defunct the pistol that you pay for. This punk, the feeling that you stay for. In time I want to be your best friend. East side lovers livingon the west end. Knocked out but boy you better come to. Don''t die, you know the truth as some do. Go write your message on the pavement. Burn so bright I wonder what the wave meant. White heat is screaming in the jungle. Complete the motion if you stumble. Go ask the dust for any answers. Come back strong with fifty belly dancers')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(6, 'Disclaimer', 'No, you can''t always get what you want. You can''t always get what you want. You can''t always get what you want. But if you try sometime you find. You get what you need. I saw her today at the reception. A glass of wine in her hand, I knew she was gonna meet her connection. At her feet was her footloose man')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(7, 'Grandmas Doilies', 'We believe variety is the key to a truly enjoyable shopping experience. Thus, our collection features leading brands that share our passion for creativity, authenticity and value. In addition, Heritage Lace has recently curated a delightful line of home decor and textile collections inspired by the award-winning PBS series Downton Abbey.')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(8, 'About Him', 'Cant stop, addicted to the shindig. Chop Top, he says Im gonna win big. Choose not a life of imitation. Distant cousin to the reservation. Defunct the pistol that you pay for. This punk, the feeling that you stay for. In time I want to be your best friend. East side lovers livingon the west end. Knocked out but boy you better come to. Don''t die, you know the truth as some do. Go write your message on the pavement. Burn so bright I wonder what the wave meant. White heat is screaming in the jungle. Complete the motion if you stumble. Go ask the dust for any answers. Come back strong with fifty belly dancers')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(9, 'Disclaimer', 'No, you can''t always get what you want. You can''t always get what you want. You can''t always get what you want. But if you try sometime you find. You get what you need. I saw her today at the reception. A glass of wine in her hand, I knew she was gonna meet her connection. At her feet was her footloose man')",

        "INSERT INTO BlogDatabaseTest.staticPages(staticPageId, staticPageTitle, staticPageContent) VALUES(10, 'Grandmas Doilies', 'Nope.org')",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(1, 'xxxlovesparklesxxx', 'sparkle', 'sugarandeverythingnoice@gmail.com', 1)",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(2, 'mrmagoo2470', 'bananas', 'iliekturtles@gmail.com', 2)",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(3, 'shroomhead48', 'sphongle', 'lsdandshrooms@gmail.com', 2)",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(4, 'stonersrule', 'marijuanapls', '420alldaybb@gmail.com', 2)",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(5, 'straightEdge666', 'stop420culture', 'drugssuck@gmail.com', 3)",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(6, 'mathbotasian', 'taylorsseries', 'thehumancalculator@gmail.com', 3)",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(7, 'imonly12watisthis', 'ohhai', 'mylittlepony@gmail.com', 3)",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(8, 'cr1ppin4lyfe', 'tupacrulez', 'bonethugznharmony@gmail.com', 3)",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(9, 'b1gd1ck$0nl0ck', 'whardahoneysat', 'looking4dahoneys@gmail.com', 3)",

        "INSERT INTO BlogDatabaseTest.users(userId, userName, userPassword, userEmail, roleId) VALUES(10, 'instagramAngelica', 'ihavenoheart', 'itakeselfieseveryday@gmail.com', 3)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(1,10,'2017-02-13 01:02:04','2017-12-30 04:05:06','2017-02-13 01:02:03',null,0,'Sic Semper Tyrannis','Lorem ipsum dolor sit amet, lectus vulputate cras cillum, tortor duis quis. Lorem vitae vel eu eget dolor diam, tempor volutpat, odio mauris curabitur adipiscing morbi non. Tempus praesent mauris aliquam vulputate lorem, elit sodales praesent gravida, rhoncus consequat et ridiculus non aliquam, sed non vel mattis, scelerisque malesuada cras in. Commodo et, molestie culpa bibendum, dis in orci quis tortor, vitae aliquam, velit lectus. Sed venenatis mauris tempor mauris dis, dui nunc fermentum justo. Sed lectus a laoreet urna nibh, ligula mauris, vel etiam phasellus fames facilisis facilisis urna, vitae aliquet lorem urna, at libero eget platea et et. Ligula curabitur ut, ultrices facilisis magna natoque diam, nullam mauris in, pretium laborum. Nulla cras laoreet pellentesque urna, morbi tristique platea orci. Vehicula integer nullam diam dui aliquam commodo, aliquam volutpat, sodales sit, integer aliquam pellentesque volutpat etiam vel molestie. Vehicula sit tristique arcu orci, tortor consequat arcu id, aliquam pellentesque diam mus.',1)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(2,9,'2017-04-20 10:11:13',null,'2017-04-20 10:11:12','2017-05-20 10:11:13',1,'Fidelis Constans','Lorem ipsum dolor sit amet, consectetur adipiscing elit. An eum discere ea mavis, quae cum plane perdidiceriti nihil sciat? Igitur neque stultorum quisquam beatus neque sapientium non beatus. Sint modo partes vitae beatae. Beatus autem esse in maximarum rerum timore nemo potest. Aliena dixit in physicis nec ea ipsa, quae tibi probarentur; Sed quid attinet de rebus tam apertis plura requirere?',6)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(3,8,'2017-7-19 19:20:22','2017-12-15 22:23:24','2017-07-19 19:20:21',null,0,'Semper Fidelis','Quae hic rei publicae vulnera inponebat, eadem ille sanabat. Itaque hoc frequenter dici solet a vobis, non intellegere nos, quam dicat Epicurus voluptatem. Suo enim quisque studio maxime ducitur. Sed tamen intellego quid velit. Ego vero volo in virtute vim esse quam maximam; Deinde prima illa, quae in congressu solemus: Quid tu, inquit, huc?',2)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(4,7,'2017-8-20 01:02:04',null,'2017-08-20 01:02:03','2017-09-20 02:03:04',1,'Salve','Haec quo modo conveniant, non sane intellego. At negat Epicurus-hoc enim vestrum lumen estquemquam, qui honeste non vivat, iucunde posse vivere. Quod equidem non reprehendo; Ita prorsus, inquam; Quid, quod res alia tota est? Quo plebiscito decreta a senatu est consuli quaestio Cn.',7)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(5,6,'2017-9-20 05:06:08','2017-11-12 08:09:10','2017-09-20 05:06:07',null,0,'Imperator Germanicus','Duo Reges: constructio interrete. Tu autem negas fortem esse quemquam posse, qui dolorem malum putet. Ab hoc autem quaedam non melius quam veteres, quaedam omnino relicta. Alterum significari idem, ut si diceretur, officia media omnia aut pleraque servantem vivere. Nihil opus est exemplis hoc facere longius.',3)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(6,5,'2017-10-20 08:09:10',null,'2017-10-20 08:09:09','2017-11-05 08:09:10',1,'Imperator Caesar','At enim hic etiam dolore. Num igitur eum postea censes anxio animo aut sollicito fuisse? Intrandum est igitur in rerum naturam et penitus quid ea postulet pervidendum; Septem autem illi non suo, sed populorum suffragio omnium nominati sunt.',8)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(7,4,'2017-11-20 11:12:13','2018-01-10 14:15:16','2017-11-07 11:12:12',null,0,'Laterculus Veronensis','Hanc quoque iucunditatem, si vis, transfer in animum; Tu autem, si tibi illa probabantur, cur non propriis verbis ea tenebas? Laelius clamores sofòw ille so lebat Edere compellans gumias ex ordine nostros. At hoc in eo M. Egone quaeris, inquit, quid sentiam? O magnam vim ingenii causamque iustam, cur nova existeret disciplina! Perge porro. Minime vero istorum quidem, inquit. Cur deinde Metrodori liberos commendas?',4)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(8,3,'2017-12-20 13:14:15',null,'2017-11-05 13:14:14','2017-11-06 14:15:16',1,'Quid Novi','Graccho, eius fere, aequalí? Haec et tu ita posuisti, et verba vestra sunt. At quicum ioca seria, ut dicitur, quicum arcana, quicum occulta omnia? Atque haec coniunctio confusioque virtutum tamen a philosophis ratione quadam distinguitur. Sed nunc, quod agimus; Aperiendum est igitur, quid sit voluptas; Omnia contraria, quos etiam insanos esse vultis. Sin te auctoritas commovebat, nobisne omnibus et Platoni ipsi nescio quem illum anteponebas?',9)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(9,2,'2018-01-15 16:17:18','2018-04-20 19:20:21','2017-11-01 16:17:17',null,0,'Vos Scitis Supellectilem','Non autem hoc: igitur ne illud quidem. Itaque ab his ordiamur. Scisse enim te quis coarguere possit? Pugnant Stoici cum Peripateticis. Quae tamen a te agetur non melior, quam illae sunt, quas interdum optines. Est enim tanti philosophi tamque nobilis audacter sua decreta defendere. Quid est enim aliud esse versutum? Ita ne hoc quidem modo paria peccata sunt.',5)",

        "INSERT INTO BlogDatabaseTest.posts(postId,userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES(10,1,'2018-02-16 19:20:21',null,'2017-11-05 19:20:20','2017-11-07 20:21:22',1,'Et Quæ Supellectilem','Intrandum est igitur in rerum naturam et penitus quid ea postulet pervidendum; Quod ea non occurrentia fingunt, vincunt Aristonem; Nihil illinc huc pervenit. Non modo carum sibi quemque, verum etiam vehementer carum esse? Iam doloris medicamenta illa Epicurea tamquam de narthecio proment: Si gravis, brevis; Equidem etiam Epicurum, in physicis quidem, Democriteum puto.',10)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(1,1,8)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(2,2,4)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(3,2,5)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(4,3,7)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(5,4,2)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(6,5,1)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(7,5,10)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(8,6,9)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(9,8,4)",

        "INSERT INTO BlogDatabaseTest.postshashtags(postHashtagId, postId, hashtagId) VALUES(10,9,6)",
        
    };

    private static final String[] DELETE_DATA = {
        
        "SET foreign_key_checks = 0",
        
        "DELETE FROM BlogDatabaseTest.categories WHERE categoryId > 0",
        
        "DELETE FROM BlogDatabaseTest.hashtags WHERE hashtagId > 0",
        
        "DELETE FROM BlogDatabaseTest.images WHERE imageId > 0",
        
        "DELETE FROM BlogDatabaseTest.posts WHERE postId > 0",
        
        "DELETE FROM BlogDatabaseTest.postshashtags WHERE postHashtagId > 0",
        
        "DELETE FROM BlogDatabaseTest.roles WHERE roleId > 0",
        
        "DELETE FROM BlogDatabaseTest.staticPages WHERE staticPageId > 0",
        
        "DELETE FROM BlogDatabaseTest.users WHERE userId > 0",
        
        "SET foreign_key_checks = 1"
        
    };

    public void setUpDatabase() {
        tearDownDatabase();
        jdbcTemplate.batchUpdate(INSERT_DATA);
    }

    public void tearDownDatabase() {
        jdbcTemplate.batchUpdate(DELETE_DATA);
    }
    
}