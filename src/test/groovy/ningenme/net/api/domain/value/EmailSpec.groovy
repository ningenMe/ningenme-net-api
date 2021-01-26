package ningenme.net.api.domain.value

import ningenme.net.api.util.domain.value.Email
import spock.lang.Specification
import spock.lang.Unroll

class EmailSpec extends Specification {

    /**
     * emailの正規表現について
     * <a>@<b>.<c>の記法
     * <a> は英数字, '_'，'-', '.' で構成される
     * '@'の後ろはトップドメイン <c> とそれ以外のドメイン <b> に分けられる
     * <b> は英数字, '_'，'-', '.' で構成される
     * <c> は英数字のみで構成される
     * @see "https://qiita.com/str32/items/a692073af32757618042"
     */
    @Unroll
    def "of() 【正常系】Emailが正規表現を守っている #target" (){
        when:
        Email email = Email.of(target);

        then:
        notThrown(Exception)
        assert target == email.toString();

        where:
        target                  || _
        "hoge@fuga.com"         || _
        "piyo.piyo@kuru.kuru"   || _
        "ningenme@ningenme.net" || _
        "a@b.c"                 || _
    }
    @Unroll
    def "of() 【異常系】Emailが正規表現を守っていない #target" (){
        when:
        Email.of(target);

        then:
        def ex = thrown(Exception)
        assert ex instanceof IllegalArgumentException

        where:
        target                   || _
        "hogefuga.com"           || _
        "hoge@fugacom"           || _
        "h"                      || _
        "a@b"                    || _
        "abcdefghij@abcdefghij.abcdefghij.abcdefghij.abcdefghij.abcdefghij.abcdefghij.abcdefghij.abcdefghij.abcdefghij" || _
    }

    def "of() 【異常系】Emailがnull" (){
        when:
        Email.of(target);

        then:
        def ex = thrown(Exception)
        assert ex instanceof NullPointerException

        where:
        target         || _
        null           || _
    }


}