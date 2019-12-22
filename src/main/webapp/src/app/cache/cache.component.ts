import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cache',
  templateUrl: './cache.component.html',
  styleUrls: ['./cache.component.css']
})
export class CacheComponent implements OnInit {

   cacheConfig='@EnableCaching\n' +
    '@Configuration\n' +
    'public class CacheConfiguration implements CachingConfigurer {\n' +
    '\n' +
    '    public final static String CACHE_BOOK_CATEGORY = "bookCategoryCache";\n' +
    '\n' +
    '    private final Logger log = LoggerFactory\n' +
    '            .getLogger(CacheConfiguration.class);\n' +
    '\n' +
    '    @Bean\n' +
    '    @Override\n' +
    '    public CacheManager cacheManager() {\n' +
    '        log.info("Initializing simple Guava Cache manager.");\n' +
    '        SimpleCacheManager cacheManager = new SimpleCacheManager();\n' +
    '        GuavaCache cache_book_category = new GuavaCache(CACHE_BOOK_CATEGORY, CacheBuilder.newBuilder()\n' +
    '                .expireAfterWrite(1, TimeUnit.DAYS)\n' +
    '                .build());\n' +
    '        cacheManager.setCaches(Arrays.asList(cache_book_category));\n' +
    '        return cacheManager;\n' +
    '    }' +
    '\n' +
    '    @Override\n' +
    '    public CacheResolver cacheResolver() {\n' +
    '        return null;\n' +
    '    }' +
    '\n' +
    '    @Bean\n' +
    '    @Override\n' +
    '    public KeyGenerator keyGenerator() {\n' +
    '        return new SimpleKeyGenerator();\n' +
    '    }' +
    '\n' +
    '    @Override\n' +
    '    public CacheErrorHandler errorHandler() {\n' +
    '        return null;\n' +
    '    }' +
    '\n' +
    '}';

   cacheController='@RestController\n' +
     '@RequestMapping("/api/rest/book-category")\n' +
     '@Slf4j\n' +
     'public class BookCategoryRest {\n' +
     '\n' +
     '    @Autowired\n' +
     '    private BookCategoryRepository bookCategoryRepository;\n' +
     '\n' +
     '    @Cacheable(CacheConfiguration.CACHE_BOOK_CATEGORY)\n' +
     '    @GetMapping("/find")\n' +
     '    public ResponseEntity<List<BookCategory>> bookCategory() {\n' +
     '        log.info("Cache");\n' +
     '        return ResponseEntity.ok(bookCategoryRepository.findAll());\n' +
     '    }\n' +
     '}\n'

  restQuery='curl -v localhost:8080/api/rest/book-category/find';
   soapQuery='curl -X POST http://localhost:8080/ws -H \'Content-Type: text/xml\' -H \'SOAPAction: blz:getBank\' -d \' <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/books.com">\n' +
     '                 <soapenv:Header/>\n' +
     '                 <soapenv:Body>\n' +
     '                    <sch:FindBookCategoryRequest>\n' +
     '                     </sch:FindBookCategoryRequest>\n' +
     '                </soapenv:Body>\n' +
     '            </soapenv:Envelope>\'\n';
  constructor() { }

  ngOnInit() {
  }

}
