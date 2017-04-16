package ema;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gacha")
// HttpServletの継承を行います。ルール①
public class EMA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// doGet()メソッドをオーバーライドする。ル ール②
	protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
	try{
	  //フォームデータの取得
	 // getParameterで、フォームのデータを取得する。
	request.setCharacterEncoding("UTF-8");
	Integer money  = Integer.parseInt(request.getParameter("money"));
	Integer regacy  = Integer.parseInt(request.getParameter("regacy"));
	Integer regacysum  = Integer.parseInt(request.getParameter("regacysum"));
	Integer urSUM  = Integer.parseInt(request.getParameter("urSUM"));
	Integer srSUM  = Integer.parseInt(request.getParameter("srSUM"));
	Integer rSUM  = Integer.parseInt(request.getParameter("rSUM"));
	Integer dustSUM  = Integer.parseInt(request.getParameter("dustSUM"));
	regacysum += money*200;
	regacy -= money * 200;

	  //コンテンツタイプの設定
	  response.setContentType("text/html; charset=UTF-8");

	  //HTML文書の書き出し
	  response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>result</title>");
    	out.println("<style type = 'text/css'> img{width:150px}</style>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>" + money * 200 + "円使って</h1>");
	    int ur = 0;
	    int sr = 0;
	    int r = 0;
	    int dust = 0;

	    if(money == 1){

	    for(int i = 0; i < money; i++){
	    	int result = (int) (Math.random() * 1000);
	    	int index = result % 9;
	    	String [] member = {"Honoka", "Kotori", "Umi", "Hanayo", "Maki", "Rin", "Nico", "Nozomi", "Eri"};
		    if(result < 16){
		    	ur += 1;
		    	out.println("<p>UR----------------------------------------</p>");
		    	out.println("<img src='" + member[index] + "_UR.jpg'><br>");
		    }else if(result > 499){
		    	dust += 1;
		    	out.println("<p>ゴミ----------------------------------------</p>");
		    	out.println("<img src='arupaka.jpg'><br>");
		    }else if(result > 15 && result < 116){
		    	sr += 1;
		    	out.println("<p>SR----------------------------------------</p>");
		    	out.println("<img src='" + member[index] + "_SR.jpg'><br>");
		    }else{
		    	r += 1;
	    		out.println("<p>R----------------------------------------</p>");
	    		out.println("<img src='" + member[index] + "_R.jpg'><br>");
		    }
		}
	  }
	    else{
		    for(int i = 0; i < money-1; i++){
		    	int result = (int) (Math.random() * 1000);
		    	int index = result % 9;
		    	String [] member = {"Honoka", "Kotori", "Umi", "Hanayo", "Maki", "Rin", "Nico", "Nozomi", "Eri"};
			    if(result < 16){
			    	ur += 1;
			    	out.println("<p>UR----------------------------------------</p>");
			    	out.println("<img src='" + member[index] + "_UR.jpg'><br>");
			    }else if(result > 499){
			    	dust += 1;
			    	out.println("<p>ゴミ----------------------------------------</p>");
			    	out.println("<img src='arupaka.jpg'><br>");
			    }else if(result > 15 && result < 116){
			    	sr += 1;
			    	out.println("<p>SR----------------------------------------</p>");
			    	out.println("<img src='" + member[index] + "_SR.jpg'><br>");
			    }else{
			    	r += 1;
		    		out.println("<p>R----------------------------------------</p>");
		    		out.println("<img src='" + member[index] + "_R.jpg'><br>");
			    }
		    }
		    int result = (int) (Math.random() * 1000);
		    int index = result % 9;
		    String [] member = {"Honoka", "Kotori", "Umi", "Hanayo", "Maki", "Rin", "Nico", "Nozomi", "Eri"};
		    if(result<15){
		    	ur += 1;
		    	out.println("<p>UR----------------------------------------</p>");
		    	out.println("<img src='" + member[index] + "_UR.jpg'><br>");
		    }else{
		    	sr += 1;
		    	out.println("<p>SR----------------------------------------</p>");
		    	out.println("<img src='" + member[index] + "_SR.jpg'><br>");
		    }

	    }

	    urSUM += ur;
	    srSUM +=sr;
	    rSUM +=r;
	    dustSUM +=dust;



	    out.println("<p>が出たよ</p>");
	    out.println("<p>集計：</p>");
	    out.println("<p>UR: " + ur + "枚</p>");
	    out.println("<p>SR： "+ sr + "枚</p>");
	    out.println("<p>R： " + r + "枚</p>");
	    out.println("<p>ゴミ： " + dust + "枚</p>");


	    out.println("<form action='http://localhost:8080/Sample2/gacha' method='GET'>");


	    out.println("<p>----------------------------------------</p>");
	    out.println("<p>全部集計：</p>");
	    out.println("<p>UR: " + urSUM + "枚</p>");
	    out.println("<p>SR： "+ srSUM + "枚</p>");
	    out.println("<p>R： " + rSUM + "枚</p>");
	    out.println("<p>ゴミ： " + dustSUM + "枚</p>");

	    out.println("<h2>残り財産" + regacy + "円</h2>");


	    out.println("もう一度引くのん？(一回200円)<br/>");
	    out.println("単発");
	    out.println("<input type='radio' name='money' value='1'/>");
	    out.println("十連");
	    out.println("<input type='radio' name='money' value='10' checked='checked'/><br>");
	    out.println("残り財産: ");
	    out.println("<input type='text' name='regacy' value ='" + regacy + "'>");

	    out.println("<input type='hidden' name='urSUM' value='"+urSUM+"'>");
	    out.println("<input type='hidden' name='srSUM' value='"+srSUM+"'>");
	    out.println("<input type='hidden' name='rSUM' value='"+rSUM+"'>");
	    out.println("<input type='hidden' name='dustSUM' value='"+dustSUM+"'>");
	    out.println("<input type='hidden' name='regacysum' value='"+regacysum+"'>");

	    out.println("<h2>使った金額：" + regacysum + "円</h2>");

	    out.println("<input type='submit' value='送信'/>");


	    out.println("</form>");
	    out.println("</body>");
	    out.println("</html>");


	}catch(Exception e){
	   e.printStackTrace();
	}
	}
}