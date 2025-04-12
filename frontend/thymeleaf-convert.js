const fs = require('fs-extra');
const path = require('path');

// 경로 설정 (절대경로로 명확히 지정)
const SOURCE = path.resolve(__dirname, './build');
const TARGET = path.resolve(__dirname, './build-thymeleaf');

// build 폴더가 존재하지 않으면 종료
if (!fs.existsSync(SOURCE)) {
    console.error('빌드된 폴더(build)를 찾을 수 없습니다. 먼저 npm run build를 수행하세요.');
    process.exit(1);
}

// 복사
fs.removeSync(TARGET);
fs.copySync(SOURCE, TARGET);

// templates 폴더 생성 후 이동
const indexSrc = path.join(TARGET, 'index.html');
const indexDest = path.join(TARGET, 'templates', 'index.html');

fs.ensureDirSync(path.dirname(indexDest));

// index.html 파일 존재 체크
if (!fs.existsSync(indexSrc)) {
    console.error('index.html 파일이 없습니다.');
    process.exit(1);
}

fs.moveSync(indexSrc, indexDest);

// 파일 읽기
let html = fs.readFileSync(indexDest, { encoding: 'utf-8' });

// 변환 처리
html = html.replace(/href="\/static\/css\/(.*?)"/g, 'th:href="@{/static/css/$1}"');
html = html.replace(/src="\/static\/js\/(.*?)"/g, 'th:src="@{/static/js/$1}"');
html = html.replace(/<html(.*?)>/, '<html$1 xmlns:th="http://www.thymeleaf.org">');

// 파일 다시 쓰기
fs.writeFileSync(indexDest, html);

console.log('변환 완료:', indexDest);
