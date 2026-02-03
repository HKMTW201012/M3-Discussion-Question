public abstract class Person
{
    private int yearOfExperience;

    public Person(int years)
    {
        yearOfExperience = years;
    }
}



/**
 * Dean:
 * - 本职：doManage(), signDoc()
 * - 临时帮忙：doTeach(), doWork() 通过 delegation 实现
 * - 生病时可让 faculty/staff 代签 signDoc()（也是 delegation）

public class Dean extends Person implements Manageable, DocumentSigner {

    // ========== Delegation targets（委派对象/委派目标）==========

    // 当 faculty 不足时，院长“帮忙教学” -> 委派给一个 Teachable 的对象
    private Teachable teachingDelegate;

    // 当 staff 休假人手不足时，院长“帮忙做行政工作” -> 委派给一个 Workable 的对象
    private Workable workingDelegate;

    // 当院长生病时，签字职责可以交给某个 DocumentSigner（比如某些 faculty）
    private DocumentSigner signerDelegate;

    // ========== Constructor ==========
    public Dean(int yearsOfExperience) {
        super(yearsOfExperience);

        // 默认情况下，签字由院长本人完成
        this.signerDelegate = this;
    }

    // ========== 本职职责 ==========
    @Override
    public void doManage() {
        System.out.println("Dean is managing the school.");
    }

    /**
     * 注意：public signDoc() 对外统一入口
     * 但真正执行“签字”的人，可能是 Dean 本人，也可能是别人（代签）
     */
/**
 *
    @Override
    public void signDoc() {
        // [DELEGATION] 委派点：把 signDoc 的执行交给 signerDelegate
        // - 如果 signerDelegate 是某个 faculty，那么就由 faculty 来签
        // - 如果 signerDelegate 是 this（默认），则由 Dean 来签
        if (signerDelegate == null) {
            throw new IllegalStateException("No signerDelegate assigned.");
        }

        // 为避免 “this.signDoc() -> signerDelegate.signDoc() -> this.signDoc()” 无限递归：
        // 当 signerDelegate == this 时，走内部实际签字逻辑
        if (signerDelegate == this) {
            signAsDean();  // Dean 自己签
        } else {
            signerDelegate.signDoc(); // [DELEGATION] 代签（委派给别人）
        }
    }

    // Dean 实际签字动作放在 private 方法里，避免递归
    private void signAsDean() {
        System.out.println("Dean signed the document.");
    }

    // ========== 临时帮忙职责（Delegation 实现）==========

    /**
     * 院长帮忙教学：不是 Dean 自己“变成 Faculty”，而是把教学任务委派给 teachingDelegate
     */
    public void helpTeach() {
        if (teachingDelegate == null) {
            throw new IllegalStateException("No teachingDelegate assigned. Faculty shortage not handled yet.");
        }

        // [DELEGATION] 委派点：Dean 并不实现 doTeach()，而是把教学行为转交出去
        teachingDelegate.doTeach();
    }

    /**
     * 院长帮忙做 staff 的工作：把工作委派给 workingDelegate
     */
    public void helpWork() {
        if (workingDelegate == null) {
            throw new IllegalStateException("No workingDelegate assigned. Staff shortage not handled yet.");
        }

        // [DELEGATION] 委派点：Dean 并不实现 doWork()，而是转交给 Workable 对象去做
        workingDelegate.doWork();
    }

    // ========== Delegation 的配置/切换（运行时动态绑定）==========

    /**
     * 指定“教学委派对象”
     * 例：faculty 不足时，你可以 setTeachingDelegate(某个 Faculty)
     */
    public void setTeachingDelegate(Teachable delegate) {
        this.teachingDelegate = delegate;
    }

    /**
     * 指定“工作委派对象”
     * 例：staff 多人休假时，你可以 setWorkingDelegate(某个 Staff)
     */
    public void setWorkingDelegate(Workable delegate) {
        this.workingDelegate = delegate;
    }

    /**
     * 指定“签字委派对象”
     * 例：dean 生病时 setSignerDelegate(某个 FacultyWhoCanSign)
     */
    public void setSignerDelegate(DocumentSigner delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("signerDelegate cannot be null.");
        }
        this.signerDelegate = delegate;
    }


     * 恢复由 Dean 自己签字（病好了）

    public void restoreSigningToDean() {
        this.signerDelegate = this;
    }
}



