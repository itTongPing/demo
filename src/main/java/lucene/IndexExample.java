package lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import sun.reflect.generics.tree.VoidDescriptor;

import java.io.File;

public class IndexExample {
    public static void main(String[] args) throws  Exception{

        String content = "Students should be allowed to go out with their friends, but not allowed to drink beer";

          File indexDirectory   = new File("E:/lucene/index");


            Document document = new Document();

            Field field = new StoredField("name", content);

            document.add(field);


        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);

        Directory directory = FSDirectory.open(indexDirectory.toPath());
        IndexWriter indexWriter = new IndexWriter(directory, config);

        indexWriter.addDocument(document);

        indexWriter.close();

    }

    @Test
    public void test() throws Exception{
// 第一步：创建一个Directory对象，也就是索引库存放的位置。

        Directory directory = FSDirectory.open(new File("E:/lucene/index").toPath());
        // 第二步：创建一个indexReader对象，需要指定Directory对象。
        IndexReader indexReader = DirectoryReader.open(directory);
        // 第三步：创建一个indexSearcher对象，需要指定IndexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        // 第四步：创建一个TermQuery对象，指定查询的域和查询的关键词。
        Query query = new TermQuery(new Term("name", "go"));
        // 第五步：执行查询（显示条数）
        TopDocs topDocs = indexSearcher.search(query, 10);
        // 第六步：返回查询结果。遍历查询结果并输出。
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            // 文件名称
            String fileName = document.get("name");
            System.out.println(fileName);
            // 文件内容
            String fileContent = document.get("fileContent");
            System.out.println(fileContent);
            // 文件大小
            String fileSize = document.get("fileSize");
            System.out.println(fileSize);
            // 文件路径
            String filePath = document.get("filePath");
            System.out.println(filePath);
            System.out.println("------------");
        }
        // 第七步：关闭IndexReader对象
        indexReader.close();

    }
@Test
    public void test02(){
     String str = "abc";
     String str2 = new String("abc");

     System.out.println(str==str2);






    }
}
