package cn.edu.ustb.cbwstc.view;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.skin.BusinessBlackSteelSkin;
import org.jvnet.substance.skin.CremeSkin;
import org.jvnet.substance.skin.SubstanceAutumnLookAndFeel;
import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;

import javax.swing.*;

/**
 * Created by Administrator on 2017/10/6 0006.
 */
public class SetAppearence {
    public void setSubstance() {
        try {
            // 设置外观
            UIManager.setLookAndFeel(new SubstanceLookAndFeel());
//            UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
//            UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessLookAndFeel");
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
            // 设置主题
            SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
            // 设置按钮外观
            SubstanceLookAndFeel.setCurrentButtonShaper(new StandardButtonShaper()); // 设置水印
            //SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
            // 设置边框
//            SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
            // 设置渐变渲染
//            SubstanceLookAndFeel
//                    .setCurrentGradientPainter(new StandardGradientPainter());
            // 设置标题
//            SubstanceLookAndFeel
//                    .setCurrentTitlePainter(new MatteHeaderPainter());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }
}
