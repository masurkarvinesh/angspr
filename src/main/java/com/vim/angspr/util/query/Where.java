package com.vim.angspr.util.query;

public class Where {

  private Condition condition;
  private Condition[] conditions;

  public static class builder {

    private Condition[] conditions;
    public builder conditions(Condition[] conditions) {
      this.conditions = conditions;
      return this;
    }

    private Condition condition;
    public builder equals(Condition condition) {
      this.condition = condition;
      return this;
    }

    public Where build() {
      return new Where(this);
    }
  }

  private Where(builder bldr) {
    this.conditions = bldr.conditions;
    this.condition = bldr.condition;
  }

  public String where(){
    String whereEval = new String();
    if(null != this.conditions && this.conditions.length > 0) {
      whereEval += "( ";
      for (Condition condition: conditions) {
        whereEval += condition.evaluate();
      }
      whereEval += " )";
    } else if(null != this.condition) {
      whereEval = this.condition.evaluate();
    }
    return whereEval;
  }

}
