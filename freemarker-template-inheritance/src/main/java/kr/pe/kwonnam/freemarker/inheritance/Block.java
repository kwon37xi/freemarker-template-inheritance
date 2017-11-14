package kr.pe.kwonnam.freemarker.inheritance;

/**
 * Block.
 * 
 * User: Matteo Silvestri(matteosilv@gmail.com}
 * Date: 17. 10. 26
 * Time: 오전 10:38
 */
public class Block {

    private final String name;
    private final PutType type;
    private final String content;

    public String getName() {
        return name;
    }

    public PutType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public Block(String name, PutType type, String content) {
        this.name = name;
        this.type = type;
        this.content = content;
    }
}
