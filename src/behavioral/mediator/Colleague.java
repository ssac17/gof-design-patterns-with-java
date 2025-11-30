package behavioral.mediator;

/**
 * Colleague 인터페이스는 중재자에게 상담을 의뢰할 멤버를 나타내는 인터페이스입니다.
 * 구체적인 멤버 ColleagueButton, ColleagueTextField, ColleagueCheckbox가 이 인터페이스를 구현합니다.
 * setMediator 메서드는 Mediator 인터페이스를 구현한 LoginFrame 클래스가 '내가 중재자니까 기억해 주세요'라는 의미를
 * 담아서 호출하는 메서드입니다. 이 메서도의 인수로 전달된 인스턴스는 나중에 상담이 필요할(colleagueChanged를 호출할 때) 사용합니다.
 * setColleagueEnabled 메서드는 중재자로부터 내려오는 '지시'에 해당합니다. 인수 enabled가 true면 자기 자기 자신을 '활성 상태'로
 * 만들고, false면 자기 자신을 '비활성 상태'로 만듭니다. 이 메서드는 자신이 '활성 상태'가 되어야 하는지, '비활성 상태'가 되어야 하는지
 * 스스로 판단하는 것이 아니라 중재자의 판단에 따라 결정함을 나타냅니다.
 *
 */
public interface Colleague {
    //Mediator 설정
    public abstract void setMediator(Mediator mediator);

    //Mediator에서 활성/비활성을 지시
    public abstract void setColleagueEnabled(boolean enabled);
}
