package edu.khai.renderer;

import com.jogamp.opengl.GL2;
import edu.khai.PointGenerator;
import edu.khai.math.structure.Edge;
import edu.khai.math.structure.Point;
import edu.khai.math.structure.Triangle;

import java.util.ArrayList;
import java.util.List;

public class VoronoiSphereRenderer {
    private static List<Point> spherePoints = new PointGenerator().generatePoints();
    public static void drawVoronoiSphere(GL2 gl, float rotateX, float rotateY) {



      /*  // Вычисление диаграммы Вороного
        List<Triangle> voronoiDiagram = computeVoronoiDiagram(spherePoints);

        // Отображение диаграммы Вороного
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE); // Отображение только границ треугольников

        for (Triangle triangle : voronoiDiagram) {
            gl.glBegin(GL2.GL_TRIANGLES);
            for (Point vertex : triangle.getVertices()) {
                gl.glVertex3d(vertex.x, vertex.y, vertex.z);
            }
            gl.glEnd();
        }

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL); // Вернемся к отображению полных треугольников*/
    }



    private static List<Triangle> computeVoronoiDiagram(List<Point> points) {
        List<Triangle> triangles = new ArrayList<>();

        // Вычисление диаграммы Делоне
        List<Triangle> delaunayTriangles = new ArrayList<>() /*computeDelaunayTriangulation(points)*/;

        // Построение выпуклой оболочки
        List<Triangle> convexHull = computeConvexHull(points);

        // Фильтрация треугольников, принадлежащих выпуклой оболочке
        for (Triangle triangle : delaunayTriangles) {
            if (!isTriangleInConvexHull(triangle, convexHull)) {
                triangles.add(triangle);
            }
        }

        return triangles;
    }

//    private static List<Triangle> computeDelaunayTriangulation(List<Point> points) {
//        List<Triangle> triangles = new ArrayList<>();
//
//        if (points.size() < 3) {
//            // Для менее чем трех точек триангуляция не требуется
//            return triangles;
//        }
//
//        // Добавим первые три точки в триангуляцию
//        triangles.add(new Triangle(points.get(0), points.get(1), points.get(2)));
//
//        // Перебор оставшихся точек
//        for (int i = 3; i < points.size(); i++) {
//            Point newPoint = points.get(i);
//
//            // Список треугольников, подлежащих удалению
//            List<Triangle> trianglesToRemove = new ArrayList<>();
//
//            // Перебор всех существующих треугольников
//            for (Triangle triangle : triangles) {
////                if (triangle.isPointInsideCircumcircle(newPoint)) {
//                    // Точка внутри описанной окружности треугольника
//                    trianglesToRemove.add(triangle);
//                }
//            }
//
//            // Формируем новые треугольники, используя текущую точку
//            List<Edge> edges = new ArrayList<>();
//
//            for (Triangle triangle : trianglesToRemove) {
//                edges.add(new Edge(triangle.getVertex(0), triangle.getVertex(1)));
//                edges.add(new Edge(triangle.getVertex(1), triangle.getVertex(2)));
//                edges.add(new Edge(triangle.getVertex(2), triangle.getVertex(0)));
//            }
//
//            // Удаляем треугольники, которые будут заменены новыми
//            triangles.removeAll(trianglesToRemove);
//
//            for (Edge edge : edges) {
//                triangles.add(new Triangle(edge.start, edge.end, newPoint));
//            }
//        }
//
//        return triangles;
//    }

    private static List<Triangle> computeConvexHull(List<Point> points) {
        // Ваш код для построения выпуклой оболочки
        // Здесь можно использовать, например, алгоритм Грэхема или другие
        // Результат должен быть списком треугольников
        return new ArrayList<>();
    }

    private static boolean isTriangleInConvexHull(Triangle triangle, List<Triangle> convexHull) {
        // Проверка, принадлежит ли треугольник выпуклой оболочке
        // Это может потребовать дополнительных вычислений, в зависимости от используемого метода
        return false;
    }


}
