package ch.ralscha.extdirectspring.demo.group;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Named;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;

import com.google.common.collect.ImmutableList;

@Named
public class GroupAction {

  private static List<Task> tasks;

  static {
    ImmutableList.Builder<Task> builder = new ImmutableList.Builder<Task>();
    builder.add(new Task(100, "Ext Forms: Field Anchoring", 112, "Integrate 2.0 Forms with 2.0 Layouts",
        new BigDecimal(6), new BigDecimal(150), 2010, 6, 24));
    builder.add(new Task(100, "Ext Forms: Field Anchoring", 113, "Implement AnchorLayout", new BigDecimal(4),
        new BigDecimal(150), 2010, 6, 25));
    builder.add(new Task(100, "Ext Forms: Field Anchoring", 114, "Add support for multiple types of anchors",
        new BigDecimal(4), new BigDecimal(150), 2010, 6, 27));
    builder.add(new Task(100, "Ext Forms: Field Anchoring", 115, "Testing and debugging", new BigDecimal(8),
        new BigDecimal(0), 2010, 6, 29));
    builder.add(new Task(101, "Ext Grid: Single-level Grouping", 101, "Add required rendering 'hooks' to GridView",
        new BigDecimal(6), new BigDecimal(100), 2010, 7, 1));
    builder.add(new Task(101, "Ext Grid: Single-level Grouping", 102,
        "Extend GridView and override rendering functions", new BigDecimal(6), new BigDecimal(100), 2010, 7, 3));
    builder.add(new Task(101, "Ext Grid: Single-level Grouping", 103, "Extend Store with grouping functionality",
        new BigDecimal(4), new BigDecimal(100), 2010, 7, 4));
    builder.add(new Task(101, "Ext Grid: Single-level Grouping", 121, "Default CSS Styling", new BigDecimal(2),
        new BigDecimal(100), 2010, 7, 5));
    builder.add(new Task(101, "Ext Grid: Single-level Grouping", 104, "Testing and debugging", new BigDecimal(6),
        new BigDecimal(100), 2010, 7, 6));
    builder.add(new Task(102, "Ext Grid: Summary Rows", 105, "Ext Grid plugin integration", new BigDecimal(4),
        new BigDecimal(125), 2010, 7, 1));
    builder.add(new Task(102, "Ext Grid: Summary Rows", 106, "Summary creation during rendering phase", new BigDecimal(
        4), new BigDecimal(125), 2010, 7, 2));
    builder.add(new Task(102, "Ext Grid: Summary Rows", 107, "Dynamic summary updates in editor grids", new BigDecimal(
        6), new BigDecimal(125), 2010, 7, 5));
    builder.add(new Task(102, "Ext Grid: Summary Rows", 108, "Remote summary integration", new BigDecimal(4),
        new BigDecimal(125), 2010, 7, 5));
    builder.add(new Task(102, "Ext Grid: Summary Rows", 109, "Summary renderers and calculators", new BigDecimal(4),
        new BigDecimal(125), 2010, 7, 6));
    builder.add(new Task(102, "Ext Grid: Summary Rows", 110, "Integrate summaries with GroupingView",
        new BigDecimal(10), new BigDecimal(125), 2010, 7, 11));
    builder.add(new Task(102, "Ext Grid: Summary Rows", 111, "Testing and debugging", new BigDecimal(8),
        new BigDecimal(125), 2010, 7, 15));
    
    tasks = builder.build();

  }

  @ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "total")
  public List<Task> load(ExtDirectStoreReadRequest request) {
    return tasks;
  }
}
