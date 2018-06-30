# 修了課題(必修) 単語カウントプログラムの開発
背景と要求事項を読みプログラムを完成させなさい。

## 背景
XYZ英会話は英語のドラマや映画のスクリプトを解析し、英単語の頻出度を算出することで生きた会話を元に優先的に学習すべき単語やフレーズを決めるという方式を採用しており、これまでのところ大成功を収めている。  
そのためこの方式を拡大し、たとえば20代の女性など世代をしぼったり、旅行やカメラなど特定の趣味に特化した、きめの細かい学習プログラムを作成したいと考えている。  
ドラマのスクリプトはWebから簡単に入手できるが、スクリプトから英単語の頻出度のデータを集めるようなシステム構築のノウハウがなく、XYZ英会話では、このようなシステムを構築してくれるベンダを探している。  
あなたはXYZ英会話の依頼を受け、まずは指定されたスクリプトの単語の頻出度を算出するプログラムを開発することになった。  
XYZ英会話は、このプログラムを順調に開発してもらえれば、Webからクローリング＆スクレイピングするシステムの開発についても引き続き依頼したいと考えている。

## 要求事項
本プログラムはテキスト形式の英語スクリプト(日本語は含まない)を単語に分解し、  
それぞれの単語の出現回数を算出するものである。  

* 単語  
  単語の分け方について細かい規定はしないが単語と認識される単位で分解する。  
  (通常英単語はアルファベット+アポストロフィが使用可能である)  
  ただし、先頭が大文字の単語は対象から外したい。  
  これはドラマや映画は固有名詞(特に登場人物)が多く出現するが、固有名詞は学習とはあまり関係がないので除外したいからである。  
  文の先頭(主語)および疑問詞などが除外されてしまうという副作用があるが、次の理由によりこの副作用は許容できると考えている。  
  * 固有名詞を除外するには専用の辞書を作成する必要がありこの手間をかけたくない  
  * 主語や疑問詞などに出てくる単語は、既に傾向をつかんでいるため除外しても学習プログラム開発に影響がない  


* 出力形式  
  処理結果は用途に分けて3つの出力が指定できるようにしたい  
  * H2  
   H2 Databaseのデータベースの指定されたテーブルに追加書きを行う。  
   これは複数のドキュメントでの単語の頻出度の統計データを蓄積する際に使用する。  
   例えば連続ドラマの場合はシーズンごとに一つのテーブルに格納する  
   テーブル名の命名規則は自由とし、実行時に対象のテーブルを選べるようにしたい。  
   ただしテーブルのスキーマ自体は次のように決められている。
 ```
    H2=# \d wcount
                Table "public.wcount"
     Column |          Type           | Modifiers
    --------+-------------------------+-----------
     word   | character varying(1024) | not null
     count  | integer                 |
    Indexes:
        "wcount_pkey" PRIMARY KEY, btree (word)
 ```
 
   * json  
   json形式で出力を行う。  
   他のプログラムと連携する際に使用する。"word", "count"の配列形式とする。    
   プログラム連携用なので、ソートなどの見た目の加工は不要。
 ```
[
    {
        "word": "and",
        "count": 98
    },
    {
        "word": "are",
        "count": 21
    },
    {
        "word": "there",
        "count": 17
    },
    ...
 ```

   * 標準出力  
   単なる確認用として使用する。  
   標準出力の場合は見やすさを考慮し、次の点を考慮してほしい  
     * 単語出現数の降順でソート。ただし、出現数が同じ場合は辞書順  
     * 出現数を3桁で表示、ついで単語を出力

## 仕様  
要求事項から落としたプログラム仕様は次の通りとする。
* 入力ファイル  
  入力ファイルはプレーンテキストとする。日本語(が出現するかもしれないという可能性)の考慮はしなくてよい。  
  例：  
  ```
  [Scene: Central Perk, Chandler, Joey, Phoebe, and Monica are there.]
  Monica: There's nothing to tell! He's just some guy I work with!
  Joey: C'mon, you're going out with the guy! There's gotta be something wrong with him!
  Chandler: All right Joey, be nice.  So does he have a hump? A hump and a hairpiece?
  Phoebe: Wait, does he eat chalk?
  (They all stare, bemused.)
  Phoebe: Just, 'cause, I don't want her to go through what I went through with Carl- oh!
  Monica: Okay, everybody relax. This is not even a date. It's just two people going out to dinner and- not having sex.
  Chandler: Sounds like a date to me.
  [Time Lapse]
  Chandler: Alright, so I'm back in high school, I'm standing in the middle of the cafeteria, and I realize I am totally naked.
  ...
  ```

* Usage  
  **wcount** -i *infile* [-o {*H2*|*json*}]  
  -i テキスト形式の英語ドキュメント  
  -o 出力形式。省略時は標準出力とする  
  * H2  
    H2=*username*:*password*@*hostname*:*portno*/*dbname*:*tablename*  
    例：  
    ```
    wcount -i in.txt -o H2=shoji:pass1word@localhost:5432/H2:wcount
    ```
  * json  
    json=outfilename  
    例：
    ```
    wcount -i in.txt -o json=out.json
    ```

* 標準出力のフォーマット  
  出現順序の降順で出力  
  例:  
  ```
   wcount -i in  
   104 you
   102 a
    98 and
    88 the
    80 to
    55 it
    48 is
    44 of
    41 that
    35 just
   ...
    ```

* その他  
  H2 Databaseに格納する際は、UPDATE時に元のcount数を足すことを忘れないこと  