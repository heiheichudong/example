package com.gess.example.property;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gess.example.R;
import com.gess.note.BaseActivity;

public class PropertyActivity extends BaseActivity {

    private String tv = "作者：半佛仙人\n" +
            "链接：https://www.zhihu.com/question/345303992/answer/819142974\n" +
            "来源：知乎\n" +
            "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。\n" +
            "\n" +
            "其实是好事，而且你将有幸见证中国史无前例的第一家大型公司顺畅又完整的交接，在马云正式卸任董事局主席之前，阿里至少做了10年准备。几乎每一个创业者都想过要是公司缺了自己会怎么样，如何把企业健康并安全的传递下去，是无数企业都无法解决的难题。中国是一个注重血脉相传的国度，从有了朝代开始，就是父亲的帝位由儿子来继承，如果是外人接手，一般就预示着一个朝代的终结。自己辛苦打下来的江山怎么会给别人？发展到现在，辛苦打下来的江山变成了辛苦构建的商业帝国，下一代接班人的逻辑往往也是子承父业。这也就是为什么李嘉诚、刘永好会选择自己的儿女作为企业继承者。可子承父业，最大的问题在于并不能把成功传承下去。阿里现在做的交接，就是在用“合伙人制度”打破这个困境。曾经也有“马云为什么不把阿里传给儿子”的话题热议，但有一句古话叫做“富不过三代”，放在现在也无比合适。2016年瑞士联合银行有份报告指出，家族式企业传递到第二代后通常大约有30%的存活率，传递到第三代就下降到12%，只有3%~4%的家族式企业能够传递到第四代。在中国，比如著名的山西海鑫钢铁，这个山西最大的民营企业，在2003年1月创始人李海仓在办公室遇刺身亡后，不满22岁的儿子李兆会不得不中途中断学业，被推出来仓促接手了资产超过40亿的海鑫集团。显然他没办法接手父亲的关系网和各路资源，于是海鑫钢铁内部也成立了“总调度室”来帮助集体决策。李兆会本人说过：“公司是我父亲的，不能让它毁在我手里。”但是接手后，李兆会并没有能力将李海仓生前经营的人脉延续下去，又因为公司管理十分混乱，涉嫌造假，不喜实业，在10年之后，海鑫钢铁还是难逃破产的命运。";

    private View mView;
    private EditText mEditText;
    private TextView mTvTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        mView = findViewById(R.id.view);
        mEditText = findViewById(R.id.editText);
        mTvTextview = findViewById(R.id.tv_textview);
        mTvTextview.setText(tv);
        mTvTextview.setMovementMethod(new ScrollingMovementMethod());

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PropertyActivity.this,ViewPropertyActivity.class));
            }
        });
    }
}
