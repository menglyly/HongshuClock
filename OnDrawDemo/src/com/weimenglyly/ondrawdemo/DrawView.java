package com.weimenglyly.ondrawdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

public class DrawView extends View {

	public DrawView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		/*
		 * 1.Paint���ʣ�2.Canvas����3.ע�⻭��������λ�ã��±���һ�Ż����ϵģ�ע�����λ��x�����ҷ���y�����·����
		 */
		Paint paint = new Paint();
		paint.setColor(Color.CYAN);// ���ñʵ���ɫΪ��ɫ�е�һ����ɫ
		paint.setTextSize(22);// �����ı������Сʱע�ⵥλ

		canvas.drawText("��ԲȦ�Աȴ�С�;��Ч��", 20, 20, paint);// �����������ر�С����Ϊ�����Ļ�ֱ�������������������ı�λ��
		canvas.drawCircle(30, 50, 30, paint);// СԲ,����һ����ԲȦ����λ�ã��������ǰ뾶��С
		paint.setAntiAlias(true);// ���û��ʾ��Ч����true����ȥ�����߿�ͻ�ֲܴ�
		canvas.drawCircle(140, 50, 60, paint);// ��Բ

		canvas.drawText("���ߺͻ���", 20, 90, paint);
		canvas.drawLine(20, 100, 180, 100, paint);// ֱ��xֵ�����Yֵ���
		canvas.drawLine(60, 130, 60, 100, paint);// ��ֱ��
		canvas.drawLine(70, 110, 130, 140, paint);// б��
		// ��Ц������
		paint.setStyle(Paint.Style.STROKE);// ���ÿ���
		RectF oval1 = new RectF(150, 20, 180, 40);
		canvas.drawArc(oval1, 180, 180, false, paint);// С����
		oval1.set(190, 20, 220, 40);
		canvas.drawArc(oval1, 180, 180, false, paint);// С����
		oval1.set(160, 30, 210, 60);
		canvas.drawArc(oval1, 0, 180, false, paint);// С����

		canvas.drawText("�����Σ�", 10, 80, paint);
		paint.setColor(Color.GRAY);// ���û�ɫ
		paint.setStyle(Paint.Style.FILL);// ��������
		canvas.drawRect(60, 60, 80, 80, paint);// ������
		canvas.drawRect(60, 90, 160, 100, paint);// ������

		canvas.drawText("�����κ���Բ:", 10, 120, paint);
		/* ���ý���ɫ ��������ε���ɫ�Ǹı�� */
		Shader mShader = new LinearGradient(0, 0, 100, 100,
				new int[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
						Color.LTGRAY }, null, Shader.TileMode.REPEAT); // һ������,�����һ�������ݶ�����һ���ߡ�
		paint.setShader(mShader);
		// p.setColor(Color.BLUE);
		RectF oval2 = new RectF(60, 100, 200, 240);// ���ø��µĳ����Σ�ɨ�����
		canvas.drawArc(oval2, 200, 130, true, paint);
		// ��������һ��������RectF�������ǵڶ��������ǽǶȵĿ�ʼ�������������Ƕ��ٶȣ����ĸ����������ʱ�����Σ��Ǽٵ�ʱ�򻭻���
		// ����Բ����oval��һ��
		oval2.set(210, 100, 250, 130);
		canvas.drawOval(oval2, paint);

		canvas.drawText("�������Σ�", 10, 250, paint);
		// �������������,����Ի�����������
		Path path = new Path();
		path.moveTo(80, 250);// �˵�Ϊ����ε����
		path.lineTo(120, 300);
		path.lineTo(80, 300);
		path.close(); // ʹ��Щ�㹹�ɷ�յĶ����
		canvas.drawPath(path, paint);

		// ����Ի��ƺܶ��������Σ��������滭������
		paint.reset();// ����
		paint.setColor(Color.LTGRAY);
		paint.setStyle(Paint.Style.STROKE);// ���ÿ���
		Path path1 = new Path();
		path1.moveTo(180, 250);
		path1.lineTo(250, 250);
		path1.lineTo(280, 280);
		path1.lineTo(250, 280);
		path1.lineTo(180, 280);
		path1.lineTo(170, 250);
		path1.close();// ���
		canvas.drawPath(path1, paint);
		/*
		 * Path���װ����(����������ͼ�ε�·��
		 * ��ֱ�߶�*����������,�����η����ߣ�Ҳ�ɻ����ͻ���drawPath(·��������),Ҫô�����Ļ���
		 * (��������ķ��),���߿������ڼ��ϻ򻭻����ı���·����
		 */

		// ��Բ�Ǿ���
		paint.setStyle(Paint.Style.FILL);// ����
		paint.setColor(Color.LTGRAY);
		paint.setAntiAlias(true);// ���û��ʵľ��Ч��
		paint.setTextSize(18);
		canvas.drawText("��Բ�Ǿ���:", 10, 300, paint);
		RectF oval3 = new RectF(80, 300, 200, 350);// ���ø��µĳ�����
		canvas.drawRoundRect(oval3, 20, 15, paint);// �ڶ���������x�뾶��������������y�뾶

		// ������������
		canvas.drawText("������������:", 10, 380, paint);
		paint.setTextSize(18);
		paint.reset();
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.GREEN);
		Path path2 = new Path();
		path2.moveTo(100, 380);// ����Path�����
		path2.quadTo(150, 400, 170, 450); // ���ñ��������ߵĿ��Ƶ�������յ�����
		canvas.drawPath(path2, paint);// ��������������

		// ����
		paint.setStyle(Paint.Style.FILL);
		paint.setTextSize(30);
		canvas.drawText("���㣺", 10, 600, paint);
		canvas.drawPoint(60, 390, paint);// ��һ����
		canvas.drawPoints(new float[] { 60, 500, 65, 500, 70, 500 }, paint);// �������

		// ��ͼƬ��������ͼ
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		canvas.drawBitmap(bitmap, 250, 550, paint);
	}

}