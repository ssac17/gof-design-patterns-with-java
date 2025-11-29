package behavioral.visitor;

public class VisitorMain {
    static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");

        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);
        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 20000));
        rootDir.accept(new ListVisitor());
        System.out.println();

        System.out.println("Making user entries...");
        Directory youngjin = new Directory("youngjin");
        Directory gildong = new Directory("gildong");
        Directory dojin = new Directory("dojin");

        usrDir.add(youngjin);
        usrDir.add(gildong);
        usrDir.add(dojin);

        youngjin.add(new File("diary.html", 100));
        youngjin.add(new File("composite.java", 200));
        gildong.add(new File("memo.tex", 300));
        dojin.add(new File("game.doc", 400));
        dojin.add(new File("junk.mail", 500));

        rootDir.accept(new ListVisitor());
    }
}
/*
출력 결과
Making root entries...
/root (30000)
/root/bin (30000)
/root/bin/vi (10000)
/root/bin/latex (20000)
/root/tmp (0)
/root/usr (0)

Making user entries...
/root (31500)
/root/bin (30000)
/root/bin/vi (10000)
/root/bin/latex (20000)
/root/tmp (0)
/root/usr (1500)
/root/usr/youngjin (300)
/root/usr/youngjin/diary.html (100)
/root/usr/youngjin/composite.java (200)
/root/usr/gildong (300)
/root/usr/gildong/memo.tex (300)
/root/usr/dojin (900)
/root/usr/dojin/game.doc (400)
/root/usr/dojin/junk.mail (500)
 */