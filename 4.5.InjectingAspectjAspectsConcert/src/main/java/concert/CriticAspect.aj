package concert;

public aspect CriticAspect {
    public CriticAspect() {
    }

    pointcut performance() : execution(* perform(..));

    private CriticismEngine criticismEngine;

    /*afterReturning() : performance() {
        System.out.println(criticismEngine.getCriticism());
    }*/

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
